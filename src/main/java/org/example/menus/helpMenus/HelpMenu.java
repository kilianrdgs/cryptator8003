package org.example.menus.helpMenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class HelpMenu {

    private static Boolean _isChoiceCorrect = true;
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showHelpMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("                         _   _      _       _ _ ");
        menus.add("                        | | | | ___| |_ __ | | |");
        menus.add("                        | |_| |/ _ \\ | '_ \\| | |");
        menus.add("                        |  _  |  __/ | |_) |_|_|");
        menus.add("                        |_| |_|\\___|_| .__/(_|_)");
        menus.add("                                     |_|         ");        
        menus.add("----------------------------------------------------------------------------");
        if (!_isChoiceCorrect) {
            menus.add("                    VEUILLEZ CHOISIR UNE OPTION VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
        menus.add("                 [1] C'est quoi, le Chiffrement CÉSAR ?");
        menus.add("                 [2] C'est quoi, le Chiffrement VIGENÈRE ?");
        menus.add("                 [3] C'est quoi, le Chiffrement CARRÉ DE POLYBE ?");
        menus.add("                 [4] C'est quoi, le Chiffrement L.F.S.R. ?");
        menus.add("                 [5] C'est quoi, le Chiffrement MACHINE ENIGMA ?");
        menus.add("                 [6] C'est quoi, le Chiffrement RC4 ?");
        menus.add("");
        menus.add("                 [ENTER] Revenir au menu principal");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getHelpMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showHelpMenu();
            System.out.print("[OPTION CHOISIE] >>> ");
            String answer = _scan.nextLine();

            // Set up the multiple answers the user can input
            switch (answer) {
                case "1":
                    _isChoiceCorrect = true;
                    //helpMenus.getCeasarHelpMenu();
                    break;
                case "2":
                    _isChoiceCorrect = true;
                    //helpMenus.getVigenereHelpMenu();
                    break;
                case "3":
                    _isChoiceCorrect = true;
                    //helpMenus.getPolybiusHelpMenu();
                    break;
                case "4":
                    _isChoiceCorrect = true;
                    //helpMenus.getLFSRHelpMenu();
                    break;
                case "5":
                    _isChoiceCorrect = true;
                    //helpMenus.getEnigmaHelpMenu();
                    break;
                case "6":
                    _isChoiceCorrect = true;
                    //helpMenus.getRC4HelpMenu();
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
