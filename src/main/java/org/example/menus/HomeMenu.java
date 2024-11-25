package org.example.menus;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.details.ConsoleClearing;
import org.example.details.TextColors;
import org.example.menus.helpMenus.HelpMenu;

public class HomeMenu {
    private static Scanner _scan = new Scanner(System.in);
    private static Boolean _isChoiceCorrect = true;

    public static void showHomeMenu() {
        // Clears the console
        ConsoleClearing.clearConsole();

        ArrayList<String> menus = new ArrayList<>();
        menus.add(TextColors.BLUE + "   ____                  _        _                ___   ___   ___ _____ ");
        menus.add("  / ___|_ __ _   _ _ __ | |_ __ _| |_ ___  _ __   ( _ ) / _ \\ / _ \\___ / ");
        menus.add(" | |   | '__| | | | '_ \\| __/ _` | __/ _ \\| '__|  / _ \\| | | | | | ||_ \\ ");
        menus.add(" | |___| |  | |_| | |_) | || (_| | || (_) | |    | (_) | |_| | |_| |__) |");
        menus.add("  \\____|_|   \\__, | .__/ \\__\\__,_|\\__\\___/|_|     \\___/ \\___/ \\___/____/ ");
        menus.add("             |___/|_|" + TextColors.RESET);
        menus.add("----------------------------------------------------------------------------");
        if (!_isChoiceCorrect) {
            menus.add("                    VEUILLEZ CHOISIR UNE OPTION VALIDE");
            menus.add("----------------------------------------------------------------------------");
        }
        menus.add("                        [1] Chiffrer un message");
        menus.add("                        [2] Déchiffrer un message");
        menus.add("                        [3] Hacher un message");
        menus.add("                        [4] Chiffrer, puis hacher un message");
        menus.add("                        [5] Succéder plusieurs chiffrements");
        menus.add("                        [6] Besoin d'aide ?");
        menus.add("");
        menus.add(TextColors.YELLOW + "                        [ENTER] Quitter" + TextColors.RESET);
        menus.add("----------------------------------------------------------------------------");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void getHomeMenu() throws IOException, NoSuchAlgorithmException {
        while (true) {
            showHomeMenu();
            System.out.print("[OPTION CHOISIE] >>> ");
            String answer = _scan.nextLine();
            switch (answer) {
                case "1":
                    _isChoiceCorrect = true;
                    EncryptionMenu.getEncryptionMenu();
                    break;
                case "2":
                    _isChoiceCorrect = true;
                    DecryptionMenu.getDecryptionMenu();
                    break;
                case "3":
                    _isChoiceCorrect = true;
                    HashingMenu.getHashingMenu();
                    break;
                case "4":
                    _isChoiceCorrect = true;
                    EncryptionMenu.getEncryptionMenu();
                    break;
                case "5":
                    _isChoiceCorrect = true;
                    System.out.println("Succéder plusieurs chiffrements");
                    break;
                case "6":
                    _isChoiceCorrect = true;
                    HelpMenu.getHelpMenu();
                    break;
                case "":
                    _isChoiceCorrect = true;
                    ArrayList<String> menus = new ArrayList<>();
                    ConsoleClearing.clearConsole();
                    menus.add("                 _                               _        _ ");
                    menus.add("                / \\  _   _   _ __ _____   _____ (_)_ __  | |");
                    menus.add("               / _ \\| | | | | '__/ _ \\ \\ / / _ \\| | '__| | |");
                    menus.add("              / ___ \\ |_| | | | |  __/\\ V / (_) | | |    |_|");
                    menus.add("             /_/   \\_\\__,_| |_|  \\___| \\_/ \\___/|_|_|    (_)");
                    menus.add("----------------------------------------------------------------------------");
                    for (String menu : menus) {
                        System.out.println(menu);
                    }
                    return;
                default:
                    System.out.println("Veuillez choisir une option valide.\n");
                    _isChoiceCorrect = false;
                    break;
            }
        } 
    }
}
