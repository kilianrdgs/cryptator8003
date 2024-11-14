package org.example.menus.helpMenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;

public class RC4HelpMenu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showLFSRHelpMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("      _       _____ ____   ____      __  __      _   _               _ ");
        menus.add("     | |     |  ___/ ___| |  _ \\    |  \\/  | ___| |_| |__   ___   __| |");
        menus.add("     | |     | |_  \\___ \\ | |_) |   | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |");
        menus.add("     | |___ _|  _|  ___) ||  _ < _  | |  | |  __/ |_| | | | (_) | (_| |");
        menus.add("     |_____(_)_|(_)|____(_)_| \\_(_) |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|");              
        menus.add("----------------------------------------------------------------------------");
        menus.add("Le LFSR, ou Linear Feedback Shift Register, est un registre à décalage à rétroaction");
        menus.add("linéaire. Il est utilisé en cryptographie pour générer des séquences pseudo-aléatoires.");
        menus.add("Le LFSR est composé d'une graine (seed), et d'une fonction de transformation.");
        menus.add("");
        menus.add("La fonction de transformation prend en entrée les bits de la graine, et génère un nouveau");
        menus.add("bit en sortie. Ce nouveau bit est ensuite ajouté à la graine, et le bit le plus ancien est");
        menus.add("décalé d'une position.");
        menus.add("");
        menus.add("Exemple :");
        menus.add("Notons que vous ayez un LFSR de 4 bits avec une graine de 1010. La fonction de transformation");
        menus.add("est la suivante : Sur un LFSR de 4 bits, les 2e et 4e sont additionnés pour générer le nouveau.");
        menus.add("bit. Alors, en prenant les 2e et 4e bits, on passera de 1010 à 0100. Car 0+0 = 0, alors on");
        menus.add("ajoute le dernier bit au LFSR, en décalant d'un cran vers la gauche, et retirant le premier bit.");
        menus.add("Puis, on répète l'opération. 0100 deviendra 1001, puis 0011, puis 0111, etc.");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getLFSRHelpMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showLFSRHelpMenu();
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
