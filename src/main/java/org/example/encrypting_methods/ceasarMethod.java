package org.example.encrypting_methods;

import java.io.IOException;

import org.example.saving.savingMethod;

public class ceasarMethod {

    public static void ceasarEncryption(String message, int key) throws IOException {

        String encryptedMessage = "";

        int i;

        for (i = 0; i < message.length(); i++) {
            char messageLetter = message.charAt(i);
            char encryptedLetter = (char)(((messageLetter - 96) + key) % 26 + 96); // Calculates the new letter by adding the key to the ASCII value of the letter
            encryptedMessage += encryptedLetter; // Adds the newfound letter to the encrypted message
        }
        
        String filePath = System.getProperty("user.home") + "/Desktop/encrypted_files/ceasar_encrypted.csv"; // Sets the file path
        savingMethod.saveEncryption(filePath, encryptedMessage); // Saves the encrypted message

    }
}
