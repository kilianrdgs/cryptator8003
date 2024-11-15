package org.example.encrypting_methods;

import java.util.Objects;

public class Enigma {

    public static void crypt(String input, String key) { // Function called to start encryption
        StringBuilder resultWord = new StringBuilder(); // Creates a mutable string container to progressively build the final string

        for (int i = 0; i < input.length(); i++) { // Loop over the length of the message
            char ch = input.charAt(i); // Stores a character in a variable
            String transformedChar = modifyChar(String.valueOf(ch), key); // Calls the "modifyChar" function and returns the result
            resultWord.append(transformedChar); // Adds the encrypted letters to resultWord
        }

        System.out.println("Encrypted word: " + resultWord.toString());
    }

    public static void decrypt(String messageCrypted, String key) { // Function called to start decryption
        StringBuilder decryptedWord = new StringBuilder();

        for (int i = 0; i < messageCrypted.length(); i++) { // Loop over the length of the encrypted message
            char ch = messageCrypted.charAt(i);
            String decryptedChar = reverseModifyChar(String.valueOf(ch), key); // Calls the reverseModifyChar function with the character as a parameter
            decryptedWord.append(decryptedChar); // Adds the decrypted character to the final word
        }
        if (Objects.equals(key, "cvp")){
            System.out.println("Decrypted word: " + decryptedWord.toString() + " (MAIS ça VA pAS ou QUOI Lo)");
        } else {
            System.out.println("Decrypted text: " + decryptedWord.toString());
        }
    }

    // Function called to modify a character by passing it through all the rolls
    private static String modifyChar(String input, String key) {
        String result = input;

        // Initial transformation with the rolls
        for (int i = 0; i < key.length(); i++) {
            String rollPosition = String.valueOf(key.charAt(i));
            result = roll(result, rollPosition);
        }

        // Apply the mirror
        result = applyMirror(result);

        // Reverse transformation with the rolls
        for (int i = key.length() - 1; i >= 0; i--) {
            String rollPosition = String.valueOf(key.charAt(i));
            result = roll(result, rollPosition);
        }

        return result;
    }

    // Reproduces the modifyChar function but in reverse
    private static String reverseModifyChar(String input, String key) {
        String result = input;

        for (int i = 0; i < key.length(); i++) { // Loop over the key
            String rollPosition = String.valueOf(key.charAt(i)); // Retrieves the roll position from the key
            result = reverseRoll(result, rollPosition); // Calls the reverseRoll function with "itself" and the roll position as arguments
        }

        result = applyMirror(result); // Calls the applyMirror function and assigns its return value to result

        for (int i = key.length() - 1; i >= 0; i--) {
            String rollPosition = String.valueOf(key.charAt(i));
            result = reverseRoll(result, rollPosition);
        }

        return result;
    }

    // Function to invert the letter of the alphabet as a mirror
    private static String applyMirror(String input) {
        char mirroredChar = (char) ('z' - (input.charAt(0) - 'a'));
        return String.valueOf(mirroredChar);
    }

    // Function to apply a roll transformation
    private static String roll(String input, String rollPosition) {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int index = -1;

        for (int i = 0; i < alphabet.length; i++) { // Loop over the alphabet array to match the input and retrieve its position
            if (alphabet[i].equals(input)) {
                index = i;
                break;
            }
        }

        if (index == -1) return input; // Returns the input if there's an error
        String[] rollTable = getRollTable(rollPosition); // Retrieves the roll at the selected position by passing the corresponding letter as an argument
        return rollTable[index]; // Returns the letter from the roll corresponding to the index of the input
    }

    // Function to reverse a roll transformation
    private static String reverseRoll(String input, String rollPosition) {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] rollTable = getRollTable(rollPosition); // Retrieves the roll at the selected position

        int index = -1;
        for (int i = 0; i < rollTable.length; i++) {
            if (rollTable[i].equals(input)) { // Matches the index of the input with the index in the rollTable
                index = i;
                break;
            }
        }

        return (index != -1) ? alphabet[index] : input;
    }

    private static String[] getRollTable(String rollPosition) { // Represents a roll in its 26 positions
        return switch (rollPosition) {
            case "a" -> new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            case "b" -> new String[]{"b", "a", "d", "c", "f", "e", "h", "g", "j", "i", "l", "k", "n", "m", "p", "o", "r", "q", "t", "s", "v", "u", "x", "w", "z", "y"};
            case "c" -> new String[]{"c", "d", "e", "f", "g", "h", "a", "b", "j", "i", "l", "k", "n", "m", "p", "o", "r", "q", "t", "s", "u", "v", "x", "w", "y", "z"};
            case "d" -> new String[]{"d", "e", "f", "g", "h", "a", "b", "c", "k", "j", "m", "l", "o", "n", "q", "p", "s", "r", "u", "t", "w", "v", "y", "x", "z", "a"};
            case "e" -> new String[]{"e", "f", "g", "h", "a", "b", "c", "d", "l", "m", "i", "j", "p", "o", "n", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a"};
            case "f" -> new String[]{"f", "g", "h", "a", "b", "c", "d", "e", "m", "n", "j", "i", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b"};
            case "g" -> new String[]{"g", "h", "a", "b", "c", "d", "e", "f", "n", "o", "k", "l", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c"};
            case "h" -> new String[]{"h", "a", "b", "c", "d", "e", "f", "g", "o", "p", "l", "m", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d"};
            case "i" -> new String[]{"i", "j", "k", "l", "m", "n", "o", "p", "q", "a", "b", "c", "d", "e", "f", "g", "h", "t", "u", "v", "w", "x", "y", "z", "g", "d"};
            case "j" -> new String[]{"j", "k", "l", "m", "n", "o", "p", "q", "a", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h"};
            case "k" -> new String[]{"k", "l", "m", "n", "o", "p", "q", "r", "b", "c", "d", "e", "f", "g", "h", "i", "j", "s", "t", "u", "v", "w", "x", "y", "z", "a"};
            case "l" -> new String[]{"l", "m", "n", "o", "p", "q", "r", "s", "c", "d", "e", "f", "g", "h", "i", "j", "k", "t", "u", "v", "w", "x", "y", "z", "a", "b"};
            case "m" -> new String[]{"m", "n", "o", "p", "q", "r", "s", "t", "d", "e", "f", "g", "h", "i", "j", "k", "l", "u", "v", "w", "x", "y", "z", "a", "b", "c"};
            case "n" -> new String[]{"n", "o", "p", "q", "r", "s", "t", "u", "e", "f", "g", "h", "i", "j", "k", "l", "m", "v", "w", "x", "y", "z", "a", "b", "c", "d"};
            case "o" -> new String[]{"o", "p", "q", "r", "s", "t", "u", "v", "f", "g", "h", "i", "j", "k", "l", "m", "n", "w", "x", "y", "z", "a", "b", "c", "d", "e"};
            case "p" -> new String[]{"p", "q", "r", "s", "t", "u", "v", "w", "g", "h", "i", "j", "k", "l", "m", "n", "o", "x", "y", "z", "a", "b", "c", "d", "e", "f"};
            case "q" -> new String[]{"q", "r", "s", "t", "u", "v", "w", "x", "h", "i", "j", "k", "l", "m", "n", "o", "p", "y", "z", "a", "b", "c", "d", "e", "f", "g"};
            case "r" -> new String[]{"r", "s", "t", "u", "v", "w", "x", "y", "i", "j", "k", "l", "m", "n", "o", "p", "q", "z", "a", "b", "c", "d", "e", "f", "g", "h"};
            case "s" -> new String[]{"s", "t", "u", "v", "w", "x", "y", "z", "j", "k", "l", "m", "n", "o", "p", "q", "r", "a", "b", "c", "d", "e", "f", "g", "h", "i"};
            case "t" -> new String[]{"t", "u", "v", "w", "x", "y", "z", "a", "k", "l", "m", "n", "o", "p", "q", "r", "s", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
            case "u" -> new String[]{"u", "v", "w", "x", "y", "z", "a", "b", "l", "m", "n", "o", "p", "q", "r", "s", "t", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
            case "v" -> new String[]{"v", "w", "x", "y", "z", "a", "b", "c", "m", "n", "o", "p", "q", "r", "s", "t", "u", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
            case "w" -> new String[]{"w", "x", "y", "z", "a", "b", "c", "d", "n", "o", "p", "q", "r", "s", "t", "u", "v", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
            case "x" -> new String[]{"x", "y", "z", "a", "b", "c", "d", "e", "o", "p", "q", "r", "s", "t", "u", "v", "w", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
            case "y" -> new String[]{"y", "z", "a", "b", "c", "d", "e", "f", "p", "q", "r", "s", "t", "u", "v", "w", "x", "g", "h", "i", "j", "k", "l", "m", "n", "o"};
            case "z" -> new String[]{"z", "a", "b", "c", "d", "e", "f", "g", "q", "r", "s", "t", "u", "v", "w", "x", "y", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
            default -> throw new IllegalStateException("Unexpected value: " + rollPosition);
        };
    }
}
