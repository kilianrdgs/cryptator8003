package org.example.menus.decryption_menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class CeasarMenus {

    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isMessageChoiceCorrect = true;
    private static Boolean _isKeyChoiceCorrect = true;
    private static Boolean _isdecryptingOver = false;
    
    public static void showCeasarDecryptionMenu() throws IOException {
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("           ____                                               ");
        menus.add("          / ___|___  __ _ ___  __ _ _ __                      ");
        menus.add("         | |   / _ \\/ _` / __|/ _` | '__|                     ");
        menus.add("         | |__|  __/ (_| \\__ \\ (_| | |                        ");
        menus.add("          \\____\\___|\\__,_|___/\\__,_|_|     _   _              ");
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
            menus.add("                  VEUILLEZ ENTRER UN CHIFFRE VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
        if (_isdecryptingOver) {
            menus.add("                 LE MESSAGE A ÉTÉ DÉCHIFFRÉ AVEC SUCCÈS.");
            menus.add("       VOUS POURREZ LE RETROUVER SUR VOTRE BUREAU, DANS LE DOSSIER");
            menus.add("                          \"decrypted_files\"");
            menus.add("               DANS LE FICHIER \"ceasar_decrypted.csv\"");
            menus.add("----------------------------------------------------------------------------");
        }
    
        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getCeasarDecryptionMenu() throws IOException {
        String message ="";
        int key = 0;

        while (true) {
            // Call decryption menu
            showCeasarDecryptionMenu();
            System.out.print("[TAPEZ UN MESSAGE A DÉCHIFFRER] >>> ");
            message = _scan.nextLine();
            if (!message.matches("[a-zA-Z]+")) {
                _isMessageChoiceCorrect = false;
            } else {
                _isMessageChoiceCorrect = true;
                break;
            }
        }

        while (true) {
        showCeasarDecryptionMenu();
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
    
        org.example.encrypting_methods.CeasarMethod.ceasarDecryption(message, key);
        _isdecryptingOver = true;

        while (true) {
            showCeasarDecryptionMenu();
            System.out.print("[APPUYEZ SUR ENTRÉE POUR CONTINUER] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "":
                    _isdecryptingOver = false;
                    return;
                default:
                    _isdecryptingOver = false;
                    return;
            }
        }     
    }
}
