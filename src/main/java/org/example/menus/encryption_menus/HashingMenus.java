package org.example.menus.encryption_menus;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.Hash;
import org.example.details.ConsoleClearing;

public class HashingMenus {
    static String pepper = "pepper";
    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isMessageChoiceCorrect = true;
    private static Boolean _isKeyChoiceCorrect = true;
    private static Boolean _isHashingOver = false;
    
    public static void showHashingMenu(String hashType) throws IOException {
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("                    _   _           _     _             ");
        menus.add("                   | | | | __ _ ___| |__ (_)_ __   __ _ ");
        menus.add("                   | |_| |/ _` / __| '_ \\| | '_ \\ / _` |");
        menus.add("                   |  _  | (_| \\__ \\ | | | | | | | (_| |");
        menus.add("                   |_| |_|\\__,_|___/_| |_|_|_| |_|\\__, |");
        menus.add("                                                  |___/ ");
        menus.add("----------------------------------------------------------------------------");
        if (!_isMessageChoiceCorrect) {
            menus.add("          VEUILLEZ ENTRER UN MESSAGE COMPOSÉ DE LETTRES UNIQUEMENT");
            menus.add("----------------------------------------------------------------------------");
        }
        if (!_isKeyChoiceCorrect) {
            menus.add("                  VEUILLEZ ENTRER UN CHIFFRE VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
        if (_isHashingOver) {
            menus.add("                  LE MESSAGE A ÉTÉ HACHÉ AVEC SUCCÈS.");
            menus.add("       VOUS POURREZ LE RETROUVER SUR VOTRE BUREAU, DANS LE DOSSIER");
            menus.add("                           \"hashed_files\"");
            menus.add("               DANS LE FICHIER \"hashed_"+hashType+"_messages.csv\"");
            menus.add("----------------------------------------------------------------------------");
        }
    
        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getHashingMenu(String hashType) throws IOException, NoSuchAlgorithmException {
        String message ="";

        while (true) {
            // Call encryption menu
            showHashingMenu(hashType);
            System.out.print("[TAPEZ LE MESSAGE À HACHER] >>> ");
            message = _scan.nextLine();
            Hash.hash(message, hashType);
            _isHashingOver = true;
            break;
        }

        while (true) {
            showHashingMenu(hashType);
            System.out.print("[APPUYEZ SUR ENTRÉE POUR CONTINUER] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "":
                    _isHashingOver = false;
                    return;
                default:
                    _isHashingOver = false;
                    return;
            }
        }  
        

    }
}
