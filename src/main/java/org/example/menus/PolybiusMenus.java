package org.example.menus;

import org.example.Polybius;
import org.example.PolybiusSquare;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolybiusMenus {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isEncrypting; // Track whether we're encrypting or decrypting

    public static Menu getPolybiusMenu(boolean forEncryption) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "                   ____       _       _          ",
                "                  |  _ \\ ___ | |_   _| |__   ___ ",
                "                  | |_) / _ \\| | | | | '_ \\ / _ \\",
                "                  |  __/ (_) | | |_| | |_) |  __/",
                "                  |_|   \\___/|_|\\__, |_.__/ \\___|",
                "                                |___/             "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Créer un nouveau carré", () -> getCreateSquareMenu())
                .addOption("2", "Importer un carré existant", () -> handleImportSquare())
                .addOption("", "Retour", () -> isEncrypting ?
                        EncryptionMenus.getEncryptionMenu() :
                        DecryptionMenus.getDecryptionMenu()
                );
    }

    private static Menu getCreateSquareMenu() {
        Banner banner = Banner.create(
                "                 Création du Carré de Polybe",
                "                 ---------------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Création manuelle", () -> handleManualSquareCreation())
                .addOption("2", "Création aléatoire", () -> handleRandomSquareCreation())
                .addOption("", "Retour", () -> getPolybiusMenu(isEncrypting));
    }

    private static Menu handleManualSquareCreation() {
        PolybiusSquare square = new PolybiusSquare();
        List<Character> remainingChars = new ArrayList<>();

        // Initialize available characters (uppercase for display)
        for (char c : PolybiusSquare.allowedChars) {
            remainingChars.add(Character.toUpperCase(c));
        }

        System.out.println("\nCréons votre Carré de Polybe !");

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                // Show current state
                System.out.println("\nCarré de Polybe actuel :");
                square.display();

                // Show available characters
                System.out.println("\nCaractères disponibles : " + remainingChars.toString()
                        .replace("[", "")
                        .replace("]", ""));
                System.out.println("Note : W sera chiffré en VV");

                System.out.printf("\nPosition Ligne %d, Colonne %d: ", row + 1, col + 1);

                boolean validInput = false;
                while (!validInput) {
                    String input = scanner.nextLine();

                    if (input.isEmpty()) {
                        System.out.println("Veuillez entrer un caractère !");
                        continue;
                    }

                    char inputChar = Character.toLowerCase(input.charAt(0));
                    char inputCharUpper = Character.toUpperCase(input.charAt(0));

                    if (inputChar == 'w' || inputChar == 'W') {
                        System.out.println("'W' n'est pas autorisé car il sera encodé comme 'VV'");
                        continue;
                    }

                    if (!remainingChars.contains(inputCharUpper)) {
                        if (new String(PolybiusSquare.allowedChars).indexOf(inputChar) == -1) {
                            System.out.println("Veuillez entrer un caractère valide parmi les caractères disponibles !");
                        } else {
                            System.out.println("Ce caractère est déjà utilisé ! Veuillez choisir parmi les caractères disponibles.");
                        }
                        continue;
                    }

                    square.setCell(inputChar, row, col);
                    remainingChars.remove(Character.valueOf(inputCharUpper));
                    validInput = true;
                }
            }
        }

        return getConfirmSquareMenu(square);
    }

    private static Menu handleRandomSquareCreation() {
        PolybiusSquare square = PolybiusSquare.createRandomSquare();
        System.out.println("\nVoici votre carré aléatoire :");
        square.display();

        return getConfirmSquareMenu(square);
    }

    private static Menu getConfirmSquareMenu(PolybiusSquare square) {
        Banner banner = Banner.create(
                "                 Confirmation du Carré",
                "                 --------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Confirmer et continuer", () -> getSaveSquareMenu(square))
                .addOption("2", "Recommencer", () -> getCreateSquareMenu())
                .addOption("", "Retour au menu principal", () -> getPolybiusMenu(isEncrypting));
    }

    private static Menu getSaveSquareMenu(PolybiusSquare square) {
        Banner banner = Banner.create(
                "                 Sauvegarde du Carré",
                "                 ------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Sauvegarder le carré", () -> handleSaveSquare(square))
                .addOption("2", "Continuer sans sauvegarder", () -> isEncrypting ?
                        handleEncryption(square) :
                        handleDecryption(square))
                .addOption("", "Retour", () -> getConfirmSquareMenu(square));
    }

    private static Menu handleSaveSquare(PolybiusSquare square) {
        System.out.print("\nNom du fichier pour sauvegarder : ");
        String filename = scanner.nextLine();
        try {
            square.saveToFile(filename);
            System.out.println("Carré sauvegardé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
            System.out.println("Le carré sera tout de même utilisé pour la suite.");
        }
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();

        return isEncrypting ?
                handleEncryption(square) :
                handleDecryption(square);
    }


    private static Menu handleImportSquare() {
        System.out.print("\nChemin du fichier à importer : ");
        String filename = scanner.nextLine();

        try {
            PolybiusSquare square = PolybiusSquare.loadFromFile(filename);
            System.out.println("\nCarré importé avec succès :");
            square.display();
            return isEncrypting ?
                    handleEncryption(square) :
                    handleDecryption(square);
        } catch (Exception e) {
            System.out.println("Erreur lors de l'importation : " + e.getMessage());
            System.out.println("Appuyez sur Entrée pour continuer...");
            scanner.nextLine();
            return getPolybiusMenu(isEncrypting);
        }
    }

    private static Menu handleEncryption(PolybiusSquare square) {
        return getReadingModeMenu(square, true);
    }

    private static Menu handleDecryption(PolybiusSquare square) {
        return getReadingModeMenu(square, false);
    }

    private static Menu getReadingModeMenu(PolybiusSquare square, boolean isEncrypting) {
        Banner banner = Banner.create(
                "                 Mode de Lecture",
                "                 --------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Colonne puis Ligne", () -> getMessageSourceMenu(square, true, isEncrypting))
                .addOption("2", "Ligne puis Colonne", () -> getMessageSourceMenu(square, false, isEncrypting))
                .addOption("", "Retour", () -> getPolybiusMenu(isEncrypting));
    }

    private static Menu getMessageSourceMenu(PolybiusSquare square, boolean columnFirst, boolean isEncrypting) {
        Banner banner = Banner.create(
                isEncrypting ? "                 Source du Message à Chiffrer"
                        : "                 Source du Message Chiffré",
                "                 -------------------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Saisie manuelle", () -> handleMessageInput(square, columnFirst, isEncrypting, true))
                .addOption("2", "Importer depuis un fichier", () -> handleMessageInput(square, columnFirst, isEncrypting, false))
                .addOption("", "Retour", () -> getReadingModeMenu(square, isEncrypting));
    }

    private static Menu handleMessageInput(PolybiusSquare square, boolean columnFirst, boolean isEncrypting, boolean manual) {
        String message;
        if (manual) {
            System.out.print("\n" + (isEncrypting ? "Message à chiffrer : " : "Message chiffré : "));
            message = scanner.nextLine();
        } else {
            System.out.print("\nChemin du fichier : ");
            String filename = scanner.nextLine();
            try {
                message = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename)));
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture : " + e.getMessage());
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
                return getMessageSourceMenu(square, columnFirst, isEncrypting);
            }
        }

        String result = isEncrypting ?
                Polybius.encrypt(message, square, columnFirst) :
                Polybius.decrypt(message, square, columnFirst);

        System.out.println("\nMessage " + (isEncrypting ? "chiffré" : "déchiffré") + " : " + result);

        return isEncrypting ?
                getSaveResultMenu(result) : MainMenu.getMainMenu();

    }

    private static Menu getSaveResultMenu(String encryptedMessage) {
        Banner banner = Banner.create(
                "                 Sauvegarde du Message",
                "                 --------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Sauvegarder le message", () -> handleSaveMessage(encryptedMessage))
                .addOption("2", "Terminer sans sauvegarder", MainMenu::getMainMenu)
                .addOption("", "Retour", () -> getPolybiusMenu(true));
    }

    private static Menu handleSaveMessage(String message) {
        System.out.print("\nNom du fichier : ");
        String filename = scanner.nextLine();

        boolean error = false;
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(message);
            System.out.println("Message sauvegardé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
            error = true;
        }

        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
        return error ? getSaveResultMenu(message) : MainMenu.getMainMenu();
    }
}
