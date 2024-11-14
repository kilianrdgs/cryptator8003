package org.example.encrypting_methods;

import java.io.IOException;

import org.example.saving.savingMethod;

public class VigenereMethod {

    public static void vigenereEncryption(String message, String key) throws IOException {

        StringBuilder encryptedMessage = new StringBuilder();
    
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i); // Current character in the message
            char keyChar = key.charAt(i % key.length()); // Corresponding character in the key
    
            char encryptedChar = (char)((((messageChar - 'a') + (keyChar - 'a') + 1) % 26) + 'a');
    
            encryptedMessage.append(encryptedChar);
        }
    
        String filePath = System.getProperty("user.home") + "/Desktop/encrypted_files/vigenere_encrypted.csv"; // Sets the file path
        savingMethod.saveVigenereEncryption(filePath, encryptedMessage);
    }
    

    public static void vigenereDecryption(String message, String key) throws IOException {

        StringBuilder decryptedMessage = new StringBuilder();
    
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % key.length());
    
            char decryptedChar = (char)((((messageChar - 'a') - (keyChar - 'a') + 25) % 26) + 'a');
    
            decryptedMessage.append(decryptedChar);
        }
    
        String filePath = System.getProperty("user.home") + "/Desktop/decrypted_files/vigenere_decrypted.csv"; // Sets the file path
        savingMethod.saveVigenereEncryption(filePath, decryptedMessage);
    }

    
}
