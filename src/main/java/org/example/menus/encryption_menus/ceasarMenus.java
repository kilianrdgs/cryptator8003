package org.example.menus.encryption_menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.consoleClearing;

public class ceasarMenus {

    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isMessageChoiceCorrect = true;
    private static Boolean _isKeyChoiceCorrect = true;
    
    public static void showCeasarEncryptionMenu() throws IOException {
        consoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("           ____                                               ");
        menus.add("          / ___|___  __ _ ___  __ _ _ __                       ");
        menus.add("         | |   / _ \\/ _` / __|/ _` | '__|                      ");
        menus.add("         | |__|  __/ (_| \\__ \\ (_| | |                         ");
        menus.add("          \\____\\___|\\__,_|___/\\__,_|_|      _   _              ");
        menus.add("         | ____|_ __   ___ _ __ _   _ _ __ | |_(_) ___  _ __   ");
        menus.add("         |  _| | '_ \\ / __| '__| | | | '_ \\| __| |/ _ \\| '_ \\ ");
        menus.add("         | |___| | | | (__| |  | |_| | |_) | |_| | (_) | | | |");
        menus.add("         |_____|_| |_|\\___|_|   \\__, | .__/ \\__|_|\\___/|_| |_|");
        menus.add("                                |___/|_|                       ");
        menus.add("----------------------------------------------------------------------------");
        if (!_isMessageChoiceCorrect) {
            menus.add("          VEUILLEZ ENTRER UN MESSAGE COMPOSÉ DE LETTRES UNIQUEMENT");
            menus.add("----------------------------------------------------------------------------");
        }
        if (!_isKeyChoiceCorrect) {
            menus.add("                  VEUILLEZ ENTRER UN CHIFFRE VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
    
        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getCeasarEncryptionMenu() throws IOException {
        String message ="";
        int key = 0;

        while (true) {
            // Call encryption menu
            showCeasarEncryptionMenu();
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
        showCeasarEncryptionMenu();
        System.out.print("[ENTREZ LE NOMBRE DE ROTATIONS] >>> ");
        
        // Makes a try/catch so that the input can NOT be anything other than a number
        String keyInput = _scan.nextLine();
        try { 
            key = Integer.parseInt(keyInput);
            _isKeyChoiceCorrect = true;
            break;
        }
        catch (NumberFormatException e) {
            _isKeyChoiceCorrect = false;
        }
        }
    
        org.example.encrypting_methods.ceasarMethod.ceasarEncryption(message, key);
    }
}