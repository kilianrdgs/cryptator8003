package org.example.menus.decryption_menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class VigenereMenus {
    
    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isMessageChoiceCorrect = true;
    private static Boolean _isKeyChoiceCorrect = true;
    private static Boolean _isDecryptingOver = false;
    
    public static void showVigenereDecryptionMenu() throws IOException {
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("        __     ___                                           ");
        menus.add("        \\ \\   / (_) __ _  ___ _ __   ___ _ __ ___            ");
        menus.add("         \\ \\ / /| |/ _` |/ _ \\ '_ \\ / _ \\ '__/ _ \\           ");
        menus.add("          \\ V / | | (_| |  __/ | | |  __/ | |  __/           ");
        menus.add("         __\\_/  |_|\\__, |\\___|_| |_|\\___|_|_ \\___|           ");
        menus.add("         |  _ \\  ___  ___ _ __ _   _ _ __ | |_(_) ___  _ __   ");
        menus.add("         | | | |/ _ \\/ __| '__| | | | '_ \\| __| |/ _ \\| '_ \\ ");
        menus.add("         | |_| |  __/ (__| |  | |_| | |_) | |_| | (_) | | | |");
        menus.add("         |____/ \\___|\\___|_|   \\__, | .__/ \\__|_|\\___/|_| |_|");
        menus.add("                               |___/|_|                       ");      
        menus.add("----------------------------------------------------------------------------");
        if (!_isMessageChoiceCorrect) {
            menus.add("          VEUILLEZ ENTRER UN MESSAGE COMPOSÉ DE LETTRES UNIQUEMENT");
            menus.add("----------------------------------------------------------------------------");
        }
        if (!_isKeyChoiceCorrect) {
            menus.add("          VEUILLEZ ENTRER UNE CLÉ COMPOSÉE DE LETTRES UNIQUEMENT");
            menus.add("----------------------------------------------------------------------------");
        }
        if (_isDecryptingOver) {
            menus.add("                  LE MESSAGE A ÉTÉ CHIFFRÉ AVEC SUCCÈS.");
            menus.add("       VOUS POURREZ LE RETROUVER SUR VOTRE BUREAU, DANS LE DOSSIER");
            menus.add("                           \"Decrypted_files\"");
            menus.add("               DANS LE FICHIER \"vigenere_Decrypted.csv\"");
            menus.add("----------------------------------------------------------------------------");
        }
    
        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getVigenereDecryptionMenu() throws IOException {
        String message ="";
        String key = "";

        while (true) {
            // Call Decryption menu
            showVigenereDecryptionMenu();
            System.out.print("[TAPEZ UN MESSAGE A CHIFFRER] >>> ");
            message = _scan.nextLine();
            if (!message.matches("[a-zA-Z]+")) {
                _isMessageChoiceCorrect = false;
            } else {
                _isMessageChoiceCorrect = true;
                break;
            }
        }

        while (true) {
            showVigenereDecryptionMenu();
            System.out.print("[ENTREZ LE MOT SERVANT DE CLÉ DE ROTATION] >>> ");
            
            // Makes a try/catch so that the input can NOT be anything other than a number
            key = _scan.nextLine();
            if (!key.matches("[a-zA-Z]+")) {
                _isKeyChoiceCorrect = false;
            } else {
                _isKeyChoiceCorrect = true;
                break;
            }
        }

        org.example.encrypting_methods.VigenereMethod.vigenereDecryption(message, key);;
        _isDecryptingOver = true;

        while (true) {
            showVigenereDecryptionMenu();
            System.out.print("[APPUYEZ SUR ENTRÉE POUR CONTINUER] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "":
                    _isDecryptingOver = false;
                    return;
                default:
                    _isDecryptingOver = false;
                    return;
            }
        }        
    }
}