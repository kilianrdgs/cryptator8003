package org.example.menus.helpMenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class PolybiusHelpMenu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showPolybiusHelpMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("  ____       _       _     _             __  __      _   _               _ ");
        menus.add(" |  _ \\ ___ | |_   _| |__ (_)_   _ ___  |  \\/  | ___| |_| |__   ___   __| |");
        menus.add(" | |_) / _ \\| | | | | '_ \\| | | | / __| | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |");
        menus.add(" |  __/ (_) | | |_| | |_) | | |_| \\__ \\ | |  | |  __/ |_| | | | (_) | (_| |");
        menus.add(" |_|   \\___/|_|\\__, |_.__/|_|\\__,_|___/ |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|");
        menus.add("               |___/                                                        ");        
        menus.add("----------------------------------------------------------------------------");
        menus.add("Le chiffrement par le carré de Polybe est une méthode de chiffrement");
        menus.add("par substitution basée sur l'utilisation d'un carré de Polybe.");
        menus.add("Ce carré est une table de 5x5 contenant l'alphabet, sans la lettre W, dans.");
        menus.add("notre cas. Chaque lettre est représentée par ses coordonnées dans le carré.");
        menus.add("Le W sera représenté par deux lettres V de suite.");
        menus.add("");
        menus.add("Exemple :");
        menus.add("[ ] [1] [2] [3] [4] [5]");
        menus.add("[1] [A] [B] [C] [D] [E]");
        menus.add("[2] [F] [G] [H] [I] [J]");
        menus.add("[3] [K] [L] [M] [N] [O]");
        menus.add("[4] [P] [Q] [R] [S] [T]");
        menus.add("[5] [U] [V] [X] [Y] [Z]");
        menus.add("");
        menus.add("Notons que si vous voulez chiffrer le mot \"EXEMPLE\" en utilisant le chiffre des");
        menus.add("abscisses en premier, puis celui des ordonnées, vous obtiendrez le chiffrement");
        menus.add("suivant : E = 15 car étant aux coordonnées (1,5), X = 53 car étant aux,");
        menus.add("coordonnées (5,3), E = 15, M = 33, P = 41, L = 32 et E = 15.");
        menus.add("");
        menus.add("Le mot \"EXEMPLE\" sera donc chiffré en \"15531533413215\".");
        menus.add("");
        menus.add("Le mot WAGON, lui, sera chiffré en \"525211223534\". 5252 = VV = W, 11 = A, 22 = G,");
        menus.add("35 = O et 34 = N.");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getPolybiusHelpMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showPolybiusHelpMenu();
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
