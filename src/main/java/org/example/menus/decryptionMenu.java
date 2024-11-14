package org.example.menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;
import org.example.menus.decryption_menus.CeasarMenus;

public class DecryptionMenu {
    private static Scanner _scan = new Scanner(System.in);

    private static Boolean _isChoiceCorrect = true;
    
    public static void showDecryptionMenu() {
        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>();
        menus.add("               ____    __      _     _  __  __               ");
        menus.add("              |  _ \\  /_/  ___| |__ (_)/ _|/ _|_ __ ___ _ __ ");
        menus.add("              | | | |/ _ \\/ __| '_ \\| | |_| |_| '__/ _ \\ '__|");
        menus.add("              | |_| |  __/ (__| | | | |  _|  _| | |  __/ |   ");
        menus.add("              |____/ \\___|\\___|_| |_|_|_| |_| |_|  \\___|_|   ");
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
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getDecryptionMenu() throws IOException {
        while (true) {
            showDecryptionMenu();
            System.out.print("[OPTION CHOISIE] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "1":
                    _isChoiceCorrect = true;
                    CeasarMenus.getCeasarDecryptionMenu();
                    break;
                case "2":
                    _isChoiceCorrect = true;
                    System.out.println("Utiliser la méthode de Vigenère");
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
