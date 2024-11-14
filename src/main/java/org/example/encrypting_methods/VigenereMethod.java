package org.example.encrypting_methods;

public class VigenereMethod {

    public static void vigenereEncryption(String message, String key) {

        StringBuilder encryptedMessage = new StringBuilder();

        int i;

        for (i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i); // Stores the ASCII value of the letter in the word to be encrypted
            char keyChar = key.charAt(i % key.length()); // Stores the ASCII value of the letter in the encryption key
            char encryptedChar = (char)(((messageChar - 96) + (keyChar - 96)) % 26 + 96); // Adds the ASCII values of the letters in the message and the key
            encryptedMessage.append(encryptedChar);
        }
        System.out.println("Encrypted message: " + encryptedMessage);

    }

    public static void vigenereDecryption(String message, String key) {

        StringBuilder encryptedMessage = new StringBuilder();
        int i;

        for (i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i); // Stores the ASCII value of the letter in the word to be decrypted
            char keyChar = key.charAt(i % key.length()); // Stores the ASCII value of the letter in the encryption key
            char encryptedChar = (char)((((messageChar - 96) - (keyChar - 96) + 26) % 26) + 96); // Subtracts the ASCII values of the letters in the message and the key
            encryptedMessage.append(encryptedChar);
        }
        System.out.println(encryptedMessage);
    }
}
