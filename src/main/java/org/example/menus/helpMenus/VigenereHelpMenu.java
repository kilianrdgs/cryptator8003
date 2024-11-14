package org.example.menus.helpMenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class VigenereHelpMenu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showVigenereHelpMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add(" __     ___                                  __  __      _   _               _ ");
        menus.add(" \\ \\   / (_) __ _  ___ _ __   ___ _ __ ___  |  \\/  | ___| |_| |__   ___   __| |");
        menus.add("  \\ \\ / /| |/ _` |/ _ \\ '_ \\ / _ \\ '__/ _ \\ | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |");
        menus.add("   \\ V / | | (_| |  __/ | | |  __/ | |  __/ | |  | |  __/ |_| | | | (_) | (_| |");
        menus.add("    \\_/  |_|\\__, |\\___|_| |_|\\___|_|  \\___| |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|");
        menus.add("             |___/                                                               ");
        menus.add("----------------------------------------------------------------------------");
        menus.add("Le chiffrement de Vigenère est une méthode de chiffrement par substitution");
        menus.add("basée sur l'utilisation de plusieurs chiffrements de César différents.");
        menus.add("Pour se faire, vous aurez besoin de deux mots différents : Celui que vous");
        menus.add("souhaitez chiffrer, ainsi que celui qui vous servira de clé pour le chiffrer.");
        menus.add("");
        menus.add("Exemple :");
        menus.add("Notons que vous voulez chiffrer le mot \"TATA\" avec la clé \"LAMA\".");
        menus.add("T = 20e lettre de l'alphabet                L = 12e lettre de l'alphabet");
        menus.add("A = 12e lettre de l'alphabet                A = 1e lettre de l'alphabet");
        menus.add("T = 20e lettre de l'alphabet                M = 13e lettre de l'alphabet");
        menus.add("A = 12e lettre de l'alphabet                A = 1e lettre de l'alphabet");
        menus.add("");
        menus.add("T+L = 20+12 = 32e lettre de l'alphabet; donc la 26e + 6e lettre de l'alphabet, soit F");
        menus.add("A+A = 1+1 = 2e lettre de l'alphabet; soit B");
        menus.add("T+M = 20+13 = 33e lettre de l'alphabet; donc la 26e + 7e lettre de l'alphabet, soit G");
        menus.add("A+A = 1+1 = 2e lettre de l'alphabet; soit B");
        menus.add("");
        menus.add("Le mot \"TATA\" chiffré avec la clé \"LAMA\" donnera donc \"FBGB\".");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getVigenereHelpMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showVigenereHelpMenu();
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
