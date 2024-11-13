package org.example;

public class Polybius {

    public static String encrypt(String text, PolybiusSquare square, boolean columnFirst) {
        String encryptedText = "";

        // Iterate through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Find the row and column of the character in the square
            int[] charPos = square.getCharacterPosition(character);

            if (charPos == null) {
                // If the character is not in the square, add it to the encrypted text
                encryptedText += character;
                continue;
            }

            int charRow = charPos[0];
            int charCol = charPos[1];

            if (columnFirst) {
                // If the column is first, add the row and column to the encrypted text
                encryptedText += charCol + charRow;
            } else {
                // If the row is first, add the column and row to the encrypted text
                encryptedText += charRow + charCol;
            }
        }

        return encryptedText;
    }
}
