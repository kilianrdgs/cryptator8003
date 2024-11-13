package org.example.encrypting_methods;

import java.io.IOException;

import org.example.saving.savingMethod;

public class ceasarMethod {

    public static void ceasarEncryption(String message, int key) throws IOException {

        String messageChiffre = "";

        int i;

        for (i = 0; i < message.length(); i++) {
            char lettreMessage = message.charAt(i);
            char lettreChiffree = (char)(((lettreMessage - 96) + key) % 26 + 96);
            messageChiffre += lettreChiffree;
        }
        
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "\\Documents\\encryption.txt";
        savingMethod.saveEncryption(filePath, messageChiffre);

    }
}
