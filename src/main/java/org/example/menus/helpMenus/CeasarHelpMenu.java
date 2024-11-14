package org.example.menus.helpMenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class CeasarHelpMenu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showCeasarHelpMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("  ____                            __  __      _   _               _ ");
        menus.add(" / ___|___  __ _ ___  __ _ _ __  |  \\/  | ___| |_| |__   ___   __| |");
        menus.add("| |   / _ \\/ _` / __|/ _` | '__| | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |");
        menus.add("| |__|  __/ (_| \\__ \\ (_| | |    | |  | |  __/ |_| | | | (_) | (_| |");
        menus.add(" \\____\\___|\\__,_|___/\\__,_|_|    |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|");
            
        menus.add("----------------------------------------------------------------------------");
        menus.add("Le chiffrement César est une méthode de chiffrement que l'on appelle");
        menus.add("chiffrement par rotation. Le principe est de décaler chaque lettre d'un");
        menus.add("certain nombre de positions dans l'alphabet. Par exemple, avec un décalage");
        menus.add("de 3 positions, en référence à la première lettre du nom de César, le C");
        menus.add("étant la troisième lettre de l'alphabet.");
        menus.add("");
        menus.add("Exemple :");
        menus.add("Avec un décalage de 3 (trois lettres devant), la lettre A devient la lettre D.");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getCeasarHelpMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showCeasarHelpMenu();
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
