package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PolybiusSquare square = new PolybiusSquare();
        List<Character> remainingChars = new ArrayList<>();

        // Initialize the list of available characters from allowedChars
        for (char c : PolybiusSquare.allowedChars) {
            remainingChars.add(Character.toUpperCase(c));
        }

        System.out.println("Créons votre Carré de Polybe !");
        System.out.println("Entrez une lettre à la fois pour remplir la grille 5x5.\n");

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                printCurrentState(square, remainingChars, row + 1, col + 1);

                boolean validInput = false;
                while (!validInput) {
                    String input = scanner.nextLine();

                    // Check if input is empty
                    if (input.isEmpty()) {
                        System.out.println("Veuillez entrer un caractère !");
                        printCurrentState(square, remainingChars, row + 1, col + 1);
                        continue;
                    }

                    char inputChar = Character.toLowerCase(input.charAt(0));
                    char inputCharUpper = Character.toUpperCase(input.charAt(0));

                    // Check if character is W
                    if (inputChar == 'w' || inputChar == 'W') {
                        System.out.println("'W' n'est pas autorisé car il sera encodé comme 'VV'");
                        printCurrentState(square, remainingChars, row + 1, col + 1);
                        continue;
                    }

                    // Check if character is in allowed chars
                    if (!remainingChars.contains(inputCharUpper)) {
                        if (new String(PolybiusSquare.allowedChars).indexOf(inputChar) == -1) {
                            System.out.println("Veuillez entrer un caractère valide parmi les caractères disponibles !");
                        } else {
                            System.out.println("Ce caractère est déjà utilisé ! Veuillez choisir parmi les caractères disponibles.");
                        }
                        printCurrentState(square, remainingChars, row + 1, col + 1);
                        continue;
                    }

                    // Input is valid, set the character and remove it from available chars
                    square.setCell(inputChar, row, col);
                    remainingChars.remove(Character.valueOf(inputCharUpper));
                    validInput = true;
                }
            }
        }

        square = PolybiusSquare.createRandomSquare();

        // Display final square
        System.out.println("\nVotre Carré de Polybe complété :");
        square.display();

        // Get encryption mode
        boolean columnFirst = getEncryptionMode(scanner);

        // Test the square with encryption/decryption
        System.out.print("\nEntrez un message à crypter : ");
        String originalMessage = scanner.nextLine();

        String encrypted = Polybius.encrypt(originalMessage, square, columnFirst);
        System.out.println("Message crypté : " + encrypted);

        // Ask for decryption mode
        boolean columnFirstDecrypt = getEncryptionMode(scanner);

        String decrypted = Polybius.decrypt(encrypted, square, columnFirstDecrypt);
        System.out.println("Message décrypté : " + decrypted);

        scanner.close();
    }

    private static void printCurrentState(PolybiusSquare square, List<Character> remainingChars, int row, int col) {
        System.out.println("\nCarré de Polybe actuel :");
        square.display();

        System.out.println("\nCaractères disponibles : " + remainingChars.toString()
                .replace("[", "")
                .replace("]", ""));
        System.out.println("Note : W sera encodé comme VV");

        System.out.printf("\nEntrez le caractère pour la position Ligne %d, Colonne %d : ", row, col);
    }

    private static boolean getEncryptionMode(Scanner scanner) {
        while (true) {
            System.out.println("\nComment souhaitez-vous lire les coordonnées ?");
            System.out.println("1. Colonne puis Ligne");
            System.out.println("2. Ligne puis Colonne");
            System.out.print("Votre choix (1 ou 2) : ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("Choix invalide ! Veuillez entrer 1 ou 2.");
            }
        }
    }
}