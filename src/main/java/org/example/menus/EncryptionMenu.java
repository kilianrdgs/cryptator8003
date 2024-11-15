package org.example.menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;
import org.example.menus.encryption_menus.CeasarMenus;
import org.example.menus.encryption_menus.VigenereMenus;

public class EncryptionMenu {
    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isChoiceCorrect = true;

    public static void showEncryptionMenu() {

        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>(); // Creates an array of different menu options
        // Adds the different options to the array
        menus.add("                   ____ _     _  __  __               ");
        menus.add("                  / ___| |__ (_)/ _|/ _|_ __ ___ _ __ ");
        menus.add("                 | |   | '_ \\| | |_| |_| '__/ _ \\ '__|");
        menus.add("                 | |___| | | | |  _|  _| | |  __/ |   ");
        menus.add("                  \\____|_| |_|_|_| |_| |_|  \\___|_|   ");
        menus.add("----------------------------------------------------------------------------");
        if (!_isChoiceCorrect) {
            menus.add("                    VEUILLEZ CHOISIR UNE OPTION VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
        menus.add("                     [1] Méthode -CÉSAR-");
        menus.add("                     [2] Méthode -VIGENÈRE-");
        menus.add("                     [3] Méthode -CARRÉ DE POLYBE-");
        menus.add("                     [4] Méthode -L.F.S.R.-");
        menus.add("                     [5] Méthode -MACHINE ENIGMA-");
        menus.add("                     [6] Méthode -RC4-");
        menus.add("");
        menus.add("                     [ENTER] Revenir au menu principal");
        menus.add("----------------------------------------------------------------------------");

        // Display the menu
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getEncryptionMenu() throws IOException {
        while (true) {

            // Call encryption menu
            showEncryptionMenu();
            System.out.print("[OPTION CHOISIE] >>> ");
            String answer = _scan.nextLine();

            // Set up the multiple answers the user can input
            switch (answer) {
                case "1":
                    _isChoiceCorrect = true;
                    System.out.println("Utiliser la méthode de César");
                    CeasarMenus.getCeasarEncryptionMenu();
                    break;
                case "2":
                    _isChoiceCorrect = true;
                    VigenereMenus.getVigenereEncryptionMenu();
                    break;
                case "3":
                    _isChoiceCorrect = true;
                    System.out.println("Utiliser la méthode de Carré de Polybe");
                    break;
                case "4":
                    _isChoiceCorrect = true;
                    System.out.println("Utiliser la méthode de L.F.S.R.");
                    break;
                case "5":
                    _isChoiceCorrect = true;
                    System.out.println("Utiliser la méthode de la Machine Enigma");
                    break;
                case "6":
                    _isChoiceCorrect = true;
                    System.out.println("Utiliser la méthode de RC4");
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
