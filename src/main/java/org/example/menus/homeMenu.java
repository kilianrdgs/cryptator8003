package org.example.menus;

import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.consoleClearing;

public class homeMenu {
    private static Scanner _scan = new Scanner(System.in);

    public static void showHomeMenu() {
        // Clears the console
        consoleClearing.clearConsole();

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
                    encryptionMenu.getEncryptionMenu();
                    break;
                case "2":
                    decryptionMenu.getDecryptionMenu();
                    break;
                case "3":
                    System.out.println("Hacher un message");
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
}
