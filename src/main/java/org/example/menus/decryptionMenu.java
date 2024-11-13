package org.example.menus;

import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.consoleClearing;

public class decryptionMenu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void showDecryptionMenu() {
        // Clears the console
        consoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>();
        menus.add("               ____    __      _     _  __  __               ");
        menus.add("              |  _ \\  /_/  ___| |__ (_)/ _|/ _|_ __ ___ _ __ ");
        menus.add("              | | | |/ _ \\/ __| '_ \\| | |_| |_| '__/ _ \\ '__|");
        menus.add("              | |_| |  __/ (__| | | | |  _|  _| | |  __/ |   ");
        menus.add("              |____/ \\___|\\___|_| |_|_|_| |_| |_|  \\___|_|   ");
        menus.add("----------------------------------------------------------------------------");
        menus.add("                     [1] Méthode -CÉSAR-");
        menus.add("                     [2] Méthode -VIGENÈRE-");
        menus.add("                     [3] Méthode -CARRÉ DE POLYBE-");
        menus.add("                     [4] Méthode -L.F.S.R.-");
        menus.add("                     [5] Méthode -MACHINE ENIGMA-");
        menus.add("                     [6] Méthode -RC4-");
        menus.add("");
        menus.add("                     [ENTER] Revenir au menu principal");
        menus.add("----------------------------------------------------------------------------");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getDecryptionMenu() {
        while (true) {
            showDecryptionMenu();
            System.out.print("[USER INPUT] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Utiliser la méthode de César");
                    break;
                case "2":
                    System.out.println("Utiliser la méthode de Vigenère");
                    break;
                case "3":
                    System.out.println("Utiliser la méthode de Carré de Polybe");
                    break;
                case "4":
                    System.out.println("Utiliser la méthode de L.F.S.R.");
                    break;
                case "5":
                    System.out.println("Utiliser la méthode de la Machine Enigma");
                    break;
                case "6":
                    System.out.println("Utiliser la méthode de RC4");
                    break;
                case "":
                    System.out.println("Revenir au menu principal");
                    return;
                default:
                    System.out.println("Veuillez choisir une option valide.\n");
                    break;
            }
        }
    }
}
