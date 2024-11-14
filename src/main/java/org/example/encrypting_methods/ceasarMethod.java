package org.example.encrypting_methods;

import java.io.IOException;

import org.example.saving.savingMethod;

public class CeasarMethod {

    public static void ceasarEncryption(String message, int key) throws IOException {

        String encryptedMessage = "";

        int i;

        for (i = 0; i < message.length(); i++) {
            char messageLetter = message.charAt(i);
            char encryptedLetter = (char)(((messageLetter - 'a') + key) % 26 + 'a'); // Calculates the new letter by adding the key to the ASCII value of the letter
            encryptedMessage += encryptedLetter; // Adds the newfound letter to the encrypted message
        }
        
        String filePath = System.getProperty("user.home") + "/Desktop/encrypted_files/ceasar_encrypted.csv"; // Sets the file path
        savingMethod.saveEncryption(filePath, encryptedMessage); // Saves the encrypted message

    }

    public static void ceasarDecryption(String message, int key) throws IOException {

        String decryptedMessage = "";

        int i;

        for (i = 0; i < message.length(); i++) {
            char messageLetter = message.charAt(i);
            char decryptedLetter = (char)(((messageLetter - 'a' - key + 26) % 26) + 'a'); // Calculates the new letter by subtracting the key from the ASCII value of the letter
            decryptedMessage += decryptedLetter; // Adds the newfound letter to the decrypted message
        }
        
        String filePath = System.getProperty("user.home") + "/Desktop/decrypted_files/ceasar_decrypted.csv"; // Sets the file path
        savingMethod.saveEncryption(filePath, decryptedMessage); // Saves the encrypted message

    }
}
