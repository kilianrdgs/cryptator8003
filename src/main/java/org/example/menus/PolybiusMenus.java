package org.example.menus;

import org.example.encrypting_methods.Polybius;
import org.example.classes.PolybiusSquare;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolybiusMenus {
    private static Scanner scanner = new Scanner(System.in);
    protected static boolean isEncrypting;
    private static String chainMessage;
    private static boolean chainMode;

    public static Menu getPolybiusMenu(boolean forEncryption, boolean inChainMode, String currentMessage) {
        isEncrypting = forEncryption;
        chainMode = inChainMode;
        chainMessage = currentMessage;

        Banner banner = Banner.create(
                "                   ____       _       _          ",
                "                  |  _ \\ ___ | |_   _| |__   ___ ",
                "                  | |_) / _ \\| | | | | '_ \\ / _ \\",
                "                  |  __/ (_) | | |_| | |_) |  __/",
                "                  |_|   \\___/|_|\\__, |_.__/ \\___|",
                "                                |___/             "
        );

        Menu menu = new Menu().setBanner(banner);

        if (chainMode) {
            menu.setTitle("\nMessage actuel : " + chainMessage);
        }

        return menu
                .addOption("1", "Créer un nouveau carré", () -> getCreateSquareMenu())
                .addOption("2", "Importer un carré existant", () -> handleImportSquare())
                .addOption("", "Retour", () -> chainMode ? 
                        ChainMenus.getMethodSelectionMenu() :
                        (isEncrypting ? EncryptionMenus.getEncryptionMenu() : DecryptionMenus.getDecryptionMenu())
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
                .addOption("", "Retour", () -> getPolybiusMenu(isEncrypting, chainMode, chainMessage));
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
                .addOption("", "Retour au menu principal", () -> getPolybiusMenu(isEncrypting, chainMode, chainMessage));
    }

    private static Menu getSaveSquareMenu(PolybiusSquare square) {
        Banner banner = Banner.create(
                "                 Sauvegarde du Carré",
                "                 ------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Sauvegarder le carré", () -> handleSaveSquare(square))
                .addOption("2", "Continuer sans sauvegarder", () -> getReadingModeMenu(square))
                .addOption("", "Retour", () -> getConfirmSquareMenu(square));
    }

    private static Menu handleSaveSquare(PolybiusSquare square) {
        String filename = MenuUtil.getInputFromUser("Nom du fichier pour sauvegarder : ");
        try {
            square.saveToFile(filename);
            System.out.println("Carré sauvegardé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
            System.out.println("Le carré sera tout de même utilisé pour la suite.");
        }
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();

        return getReadingModeMenu(square);
    }

    private static Menu handleImportSquare() {
        String filename = MenuUtil.getInputFromUser("Chemin du fichier à importer : ");

        try {
            PolybiusSquare square = PolybiusSquare.loadFromFile(filename);
            System.out.println("\nCarré importé avec succès :");
            square.display();
            return getReadingModeMenu(square);
        } catch (Exception e) {
            System.out.println("Erreur lors de l'importation : " + e.getMessage());
            System.out.println("Appuyez sur Entrée pour continuer...");
            scanner.nextLine();
            return getPolybiusMenu(isEncrypting, chainMode, chainMessage);
        }
    }

    private static Menu getReadingModeMenu(PolybiusSquare square) {
        Banner banner = Banner.create(
                "                 Mode de Lecture",
                "                 --------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Colonne puis Ligne", () -> processMessage(square, true))
                .addOption("2", "Ligne puis Colonne", () -> processMessage(square, false))
                .addOption("", "Retour", () -> getPolybiusMenu(isEncrypting, chainMode, chainMessage));
    }

    private static Menu processMessage(PolybiusSquare square, boolean columnFirst) {
        String message = chainMode ? chainMessage : MenuUtil.getInputFromUser(
            isEncrypting ? "Message à chiffrer : " : "Message chiffré : "
        );

        try {
            String result = isEncrypting ?
                    Polybius.encrypt(message, square, columnFirst) :
                    Polybius.decrypt(message, square, columnFirst);

            System.out.println("\nMessage " + (isEncrypting ? "chiffré" : "déchiffré") + " : " + result);
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();

            if (chainMode) {
                ChainMenus.setCurrentMessage(result);
                return ChainMenus.getMethodSelectionMenu();
            } else {
                return MenuUtil.createSaveResultMenu(result, r -> getPolybiusMenu(isEncrypting, false, null));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nErreur : " + e.getMessage());
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getReadingModeMenu(square);
        }
    }
}
