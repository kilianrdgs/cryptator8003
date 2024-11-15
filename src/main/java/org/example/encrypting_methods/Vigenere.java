package org.example.encrypting_methods;

/**
 * Implementation of the Vigenère cipher encryption algorithm.
 * The Vigenère cipher is a polyalphabetic substitution cipher that uses a keyword
 * to shift letters in the message by different amounts.
 */
public class Vigenere {
    /**
     * Encrypts the given message using the Vigenère cipher algorithm.
     * 
     * @param message The message to encrypt (must be lowercase letters only)
     * @param key The encryption key (must be lowercase letters only)
     * @return The encrypted message
     */
    public String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
    
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % key.length());
    
            // Shift by key character value plus 1 (to match original implementation)
            char encryptedChar = (char)((((messageChar - 'a') + (keyChar - 'a') + 1) % 26) + 'a');
    
            encryptedMessage.append(encryptedChar);
        }
    
        return encryptedMessage.toString();
    }

    /**
     * Decrypts the given message using the Vigenère cipher algorithm.
     * 
     * @param message The message to decrypt (must be lowercase letters only)
     * @param key The decryption key (must be lowercase letters only)
     * @return The decrypted message
     */
    public String decrypt(String message, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
    
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % key.length());
    
            // Shift back by key character value plus 1 (to match original implementation)
            char decryptedChar = (char)((((messageChar - 'a') - (keyChar - 'a') + 25) % 26) + 'a');
    
            decryptedMessage.append(decryptedChar);
        }
    
        return decryptedMessage.toString();
    }
}
