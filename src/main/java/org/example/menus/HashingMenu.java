package org.example.menus;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;
import org.example.menus.encryption_menus.HashingMenus;

public class HashingMenu {
    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isChoiceCorrect = true;

    public static void showHashingMenu() {

        // Clears the console
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
        if (!_isChoiceCorrect) {
            menus.add("                    VEUILLEZ CHOISIR UNE OPTION VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
        menus.add("                          [1] Méthode -MD5-");
        menus.add("                          [2] Méthode -SHA-256-");
        menus.add("");
        menus.add("                     [ENTER] Revenir au menu principal");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getHashingMenu() throws IOException, NoSuchAlgorithmException {
        while (true) {

            // Call hashing menu
            showHashingMenu();
            System.out.print("[OPTION CHOISIE] >>> ");
            String answer = _scan.nextLine();

            // Set up the multiple answers the user can input
            switch (answer) {
                case "1":
                    _isChoiceCorrect = true;
                    HashingMenus.getHashingMenu("MD5");
                    break;
                case "2":
                    _isChoiceCorrect = true;
                    HashingMenus.getHashingMenu("SHA-256");
                    break;
                case "":
                    _isChoiceCorrect = true;
                    System.out.println("Revenir au menu principal");
                    return;
                default:
                    _isChoiceCorrect = false;
                    System.out.println("Veuillez choisir une option valide.\n");
                    break;
            }
        }
    }
}
