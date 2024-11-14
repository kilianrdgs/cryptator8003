package org.example.decrypting_methods;

import java.io.IOException;

import org.example.saving.savingMethod;

public class ceasarMethod {

    public static void ceasarDecryption(String message, int key) throws IOException {

        String decryptedMessage = "";

        int i;

        for (i = 0; i < message.length(); i++) {
            char messageLetter = message.charAt(i);
            char decryptedLetter = (char)(((messageLetter - 96) - key) % 26 + 96); // Calculates the new letter by substracting the key to the ASCII value of the letter
            decryptedMessage += decryptedLetter; // Adds the newfound letter to the decrypted message
        }
        
        String filePath = System.getProperty("user.home") + "/Desktop/decrypted_files/ceasar_decrypted.csv"; // Sets the file path
        savingMethod.saveEncryption(filePath, decryptedMessage); // Saves the encrypted message

    }
}
