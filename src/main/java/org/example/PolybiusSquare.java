package org.example;

public class PolybiusSquare {
    private static final int SIZE = 5;
    private final char[][] grid;

    public PolybiusSquare() {
        // Initialize parent list that will store 5 rows
        this.grid = new char[SIZE][SIZE];
    }

    public void setCell(int row, int column, char character) {
        // Check if coordinates are valid
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE) {
            throw new IllegalArgumentException("Coordinates must be between 0 and 4");
        }

        // All characters in the grid are uppercased
        char upperChar = Character.toUpperCase(character);

        this.grid[row][column] = upperChar;
    }

    public char getCell(int row, int column) {
        // Check if coordinates are valid
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE) {
            throw new IllegalArgumentException("Coordinates must be between 0 and 4");
        }

        // get a character from the grid
        return this.grid[row][column];
    }

    public int[] getCharacterPosition(char character) {
        char upperChar = Character.toUpperCase(character);
        int[] coordinates = new int[2];

        // Iterate through each row
        for (int i = 0; i < SIZE; i++) {
            // Iterate through each column
            for (int j = 0; j < SIZE; j++) {
                if (this.grid[i][j] == upperChar) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    return coordinates;
                }
            }
        }

        return null;
    }

    public boolean hasEmptyCell() {
        // Check if coordinates are valid
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // A char array is initialized with '\u0000' (null character) by default
                if (this.grid[i][j] == '\u0000') {
                    return true;
                }
            }
        }
        return false;
    }

    public static PolybiusSquare createRandomSquare() {
        // TODO: Create a random PolybiusSquare object
        return null;
    }

    public static PolybiusSquare loadFromFile(String fileName) {
        // TODO: Load the file and create a PolybiusSquare object
        return null;
    }

    public static void saveToFile(String fileName, PolybiusSquare square) {
        // TODO: Save the PolybiusSquare object to a file
    }

    // Get the size of the Polybius square
    public static int getSize() {
        return SIZE;
    }
}