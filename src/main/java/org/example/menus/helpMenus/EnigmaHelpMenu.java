package org.example.menus.helpMenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class EnigmaHelpMenu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showEnigmaHelpMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add(" _____       _                         __  __            _     _            ");
        menus.add("| ____|_ __ (_) __ _ _ __ ___   __ _  |  \\/  | __ _  ___| |__ (_)_ __   ___ ");
        menus.add("|  _| | '_ \\| |/ _` | '_ ` _ \\ / _` | | |\\/| |/ _` |/ __| '_ \\| | '_ \\ / _ \\");
        menus.add("| |___| | | | | (_| | | | | | | (_| | | |  | | (_| | (__| | | | | | | |  __/");
        menus.add("|_____|_| |_|_|\\__, |_| |_| |_|\\__,_| |_|  |_|\\__,_|\\___|_| |_|_|_| |_|\\___|");
        menus.add("               |___/                                                        ");                     
        menus.add("----------------------------------------------------------------------------");
        menus.add("La machine Enigma est une machine de chiffrement électromécanique utilisée par les");
        menus.add("forces armées allemandes pendant la Seconde Guerre mondiale. Elle a été inventée par");
        menus.add("l'ingénieur allemand Arthur Scherbius à la fin de la Première Guerre mondiale.");
        menus.add("");
        menus.add("La machine Enigma, en informatique, est un algorithme de chiffrement symétrique");
        menus.add("utilisé pour chiffrer et déchiffrer des messages. Il est basé sur un réseau de");
        menus.add("substitutions.");
        menus.add("");
        menus.add("Exemple :");
        menus.add("Notons que vous souhaitez écrire le mot 'HELLO'. En utilisant la machine Enigma,");
        menus.add("vous obtiendrez un message chiffré, tel que 'XKJLQ', selon les réglages des rotors.");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getEnigmaHelpMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showEnigmaHelpMenu();
            System.out.print("[APPUYEZ SUR ENTRÉE POUR CONTINUER] >>> ");
            String answer = _scan.nextLine();

            // Set up the multiple answers the user can input
            switch (answer) {
                default:
                    return;
            }
        }
    }
}
