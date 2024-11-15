package org.example.encrypting_methods;

/**
 * Implementation of the Caesar cipher encryption algorithm.
 * The Caesar cipher is a simple substitution cipher that shifts letters in the alphabet
 * by a fixed number of positions.
 */
public class Caesar {
    /**
     * Encrypts the given message using the Caesar cipher algorithm.
     * 
     * @param message The message to encrypt (must be lowercase letters only)
     * @param key The shift key (1-25)
     * @return The encrypted message
     */
    public static String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        
        for (int i = 0; i < message.length(); i++) {
            char messageLetter = message.charAt(i);
            // Calculates the new letter by adding the key to the ASCII value of the letter
            char encryptedLetter = (char)(((messageLetter - 'a') + key) % 26 + 'a');
            encryptedMessage.append(encryptedLetter);
        }
        
        return encryptedMessage.toString();
    }

    /**
     * Decrypts the given message using the Caesar cipher algorithm.
     * 
     * @param message The message to decrypt (must be lowercase letters only)
     * @param key The shift key (1-25)
     * @return The decrypted message
     */
    public static String decrypt(String message, int key) {
        StringBuilder decryptedMessage = new StringBuilder();
        
        for (int i = 0; i < message.length(); i++) {
            char messageLetter = message.charAt(i);
            // Calculates the new letter by subtracting the key from the ASCII value of the letter
            char decryptedLetter = (char)(((messageLetter - 'a' - key + 26) % 26) + 'a');
            decryptedMessage.append(decryptedLetter);
        }
        
        return decryptedMessage.toString();
    }
}
