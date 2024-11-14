package org.example.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Polybius square is a 5x5 grid of characters, where each character is unique and there are no repeated characters.
 * The characters are chosen randomly from a list of allowed characters.
 */
public class PolybiusSquare implements Serializable {
    public static final int SIZE = 5;
    public static final char[] allowedChars = "abcdefghijklmnopqrstuvxyz".toCharArray();

    private final char[][] grid;

    public PolybiusSquare() {
        // Initialize parent list that will store 5 rows
        this.grid = new char[SIZE][SIZE];
    }

    public void setCell(char character, int row, int column) {
        // All characters in the grid are lowercased
        char lowerChar = Character.toLowerCase(character);

        this.grid[row][column] = lowerChar;
    }

    public char getCell(int row, int column) {
        return this.grid[row][column];
    }

    public int[] getCharacterPosition(char character) {
        // lowercase the character because the grid is lowercased
        char lowerChar = Character.toLowerCase(character);
        int[] position = new int[2];

        // Iterate through each row
        for (int i = 0; i < SIZE; i++) {
            // Iterate through each column
            for (int j = 0; j < SIZE; j++) {
                if (this.grid[i][j] == lowerChar) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }

        return null;
    }

    public boolean hasEmptyCell() {
        // Iterate through each row
        for (int i = 0; i < SIZE; i++) {
            // Iterate through each column
            for (int j = 0; j < SIZE; j++) {
                // A char array is initialized with '\u0000' (null character) by default
                if (this.grid[i][j] == '\u0000') {
                    return true;
                }
            }
        }
        return false;
    }

    public void display() {
        // Print column numbers
        System.out.print("  | ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Print separator line
        System.out.print("--+-");
        for (int i = 0; i < SIZE * 2; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Print rows with numbers and characters
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < SIZE; j++) {
                char cell = grid[i][j];
                char upperCell = Character.toUpperCase(cell);
                // If cell is empty (null character), print a space
                System.out.print((cell == '\u0000' ? ' ' : upperCell) + " ");
            }
            System.out.println();
        }
    }

    public static PolybiusSquare createRandomSquare() {
        PolybiusSquare square = new PolybiusSquare();

        // Create a list from the allowed characters for shuffling
        List<Character> charList = new ArrayList<>();
        for (char c : allowedChars) {
            charList.add(c);
        }

        // Shuffle the characters
        Collections.shuffle(charList);

        // Fill the grid with shuffled characters
        int charIndex = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // Make sure we don't exceed the available characters
                if (charIndex < charList.size()) {
                    square.setCell(charList.get(charIndex), i, j);
                    charIndex++;
                }
            }
        }

        return square;
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static PolybiusSquare loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (PolybiusSquare) ois.readObject();
        }
    }
}