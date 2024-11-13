package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getHomeMenu();
    }

    private static Scanner _scan = new Scanner(System.in);

    public static void showHomeMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("   ____                  _        _                ___   ___   ___ _____ ");
        menus.add("  / ___|_ __ _   _ _ __ | |_ __ _| |_ ___  _ __   ( _ ) / _ \\ / _ \\___ / ");
        menus.add(" | |   | '__| | | | '_ \\| __/ _` | __/ _ \\| '__|  / _ \\| | | | | | ||_ \\ ");
        menus.add(" | |___| |  | |_| | |_) | || (_| | || (_) | |    | (_) | |_| | |_| |__) |");
        menus.add("  \\____|_|   \\__, | .__/ \\__\\__,_|\\__\\___/|_|     \\___/ \\___/ \\___/____/ ");
        menus.add("             |___/|_|                                                    ");
        menus.add("----------------------------------------------------------------------------");
        menus.add("                        [1] Chiffrer un message");
        menus.add("                        [2] Déchiffrer un message");
        menus.add("                        [3] Hacher un message");
        menus.add("                        [4] Chiffrer, puis hacher un message");
        menus.add("");
        menus.add("                        [ENTER] Quitter");
        menus.add("----------------------------------------------------------------------------");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getHomeMenu() {
        while (true) {
            showHomeMenu();
            System.out.print("[USER INPUT] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "1":
                    getEncryptionMenu();
                    break;
                case "2":
                    System.out.println("Déchiffrer un message");
                    break;
                case "3":
                    System.out.println("Hasher un message");
                    break;
                case "":
                    System.out.println("Quitter le programme");
                    return;
                default:
                    System.out.println("Veuillez choisir une option valide.\n");
                    break;
            }
        } 
    }

    public static void showEncryptionMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n               VEUILLEZ CHOISIR UNE METHODE D'ENCRYPTION");
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

    public static void getEncryptionMenu() {
        while (true) {
            showEncryptionMenu();
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