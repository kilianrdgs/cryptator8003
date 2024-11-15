package org.example.encrypting_methods;

import org.example.classes.PolybiusSquare;
import org.example.utils.TextUtil;

public class Polybius {
    /**
     * Validates that the input text contains no numbers
     * @throws IllegalArgumentException if the text contains numbers
     */
    private static void validateInput(String text) {
        if (text.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Le message ne doit pas contenir de chiffres.");
        }
    }

    public static String encrypt(String text, PolybiusSquare square, boolean columnFirst) {
        validateInput(text);
        StringBuilder encryptedText = new StringBuilder();

        // Iterate through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char character = Character.toLowerCase(text.charAt(i));
            
            // Remove accents from the character
            character = TextUtil.removeAccents(character);

            // If character is not a letter, keep it as is
            if (!Character.isLetter(character)) {
                encryptedText.append(character);
                continue;
            }

            // Special handling for 'w' - encrypt as two 'v's
            if (character == 'w') {
                int[] vPos = square.getCharacterPosition('v');
                if (vPos != null) {
                    int vRow = vPos[0] + 1;
                    int vCol = vPos[1] + 1;
                    // Add the position of 'v' twice
                    if (columnFirst) {
                        encryptedText.append(vCol).append(vRow);
                        encryptedText.append(vCol).append(vRow);
                    } else {
                        encryptedText.append(vRow).append(vCol);
                        encryptedText.append(vRow).append(vCol);
                    }
                }
                continue;
            }

            // Find the row and column of the character in the square
            int[] charPos = square.getCharacterPosition(character);

            if (charPos == null) {
                // If the character is not in the square, add it as is
                encryptedText.append(character);
                continue;
            }

            int charRow = charPos[0] + 1;
            int charCol = charPos[1] + 1;

            if (columnFirst) {
                encryptedText.append(charCol).append(charRow);
            } else {
                encryptedText.append(charRow).append(charCol);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, PolybiusSquare square, boolean columnFirst) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            // If it's not a digit, keep it as is
            if (!Character.isDigit(encryptedText.charAt(i))) {
                decryptedText.append(encryptedText.charAt(i));
                continue;
            }

            // Check if we have enough characters for a coordinate pair
            if (i + 1 >= encryptedText.length() || !Character.isDigit(encryptedText.charAt(i + 1))) {
                decryptedText.append(encryptedText.charAt(i));
                continue;
            }

            // Get the two digits that form the coordinates
            int firstDigit = Character.getNumericValue(encryptedText.charAt(i));
            int secondDigit = Character.getNumericValue(encryptedText.charAt(i + 1));

            // Skip invalid coordinates
            if (firstDigit < 1 || firstDigit > 5 || secondDigit < 1 || secondDigit > 5) {
                decryptedText.append(encryptedText.charAt(i));
                continue;
            }

            // Convert to 0-based indices
            int row = columnFirst ? secondDigit - 1 : firstDigit - 1;
            int col = columnFirst ? firstDigit - 1 : secondDigit - 1;

            char decryptedChar = square.getCell(row, col);

            // Check for possible 'w' pattern
            if (i + 3 < encryptedText.length() &&
                    Character.isDigit(encryptedText.charAt(i + 2)) &&
                    Character.isDigit(encryptedText.charAt(i + 3))) {

                int nextFirstDigit = Character.getNumericValue(encryptedText.charAt(i + 2));
                int nextSecondDigit = Character.getNumericValue(encryptedText.charAt(i + 3));

                // If next two digits represent the same position and current char is 'v'
                if (firstDigit == nextFirstDigit && secondDigit == nextSecondDigit &&
                        decryptedChar == 'v') {
                    decryptedText.append('w');
                    i += 3; // Skip the next coordinate pair
                    continue;
                }
            }

            decryptedText.append(decryptedChar);
            i++; // Skip the second digit since we've used it
        }

        return decryptedText.toString();
    }
}
