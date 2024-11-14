package org.example.utils.menu;

import org.example.menus.MainMenu;
import org.example.utils.FileUtil;

import java.util.Scanner;
import java.util.function.Function;

public class MenuUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputFromUser(String prompt) {
        System.out.print("\n" + prompt);
        return scanner.nextLine();
    }

    public static Menu createSaveResultMenu(String result, Function<String, Menu> returnMenu) {
        Banner banner = Banner.create(
                "                 Sauvegarde du Message",
                "                 --------------------"
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Sauvegarder le message", () -> handleSaveMessage(result, returnMenu))
                .addOption("2", "Terminer sans sauvegarder", MainMenu::getMainMenu)
                .addOption("", "Retour", () -> returnMenu.apply(result));
    }

    private static Menu handleSaveMessage(String message, Function<String, Menu> returnMenu) {
        String filename = getInputFromUser("Nom du fichier : ");
        boolean error = FileUtil.saveToFile(filename, message);

        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
        return error ? createSaveResultMenu(message, returnMenu) : MainMenu.getMainMenu();
    }

    public static String getMessageFromInput(boolean manual, Function<Void, Menu> returnMenu) {
        if (manual) {
            return getInputFromUser("Message : ");
        } else {
            String filename = getInputFromUser("Chemin du fichier : ");
            try {
                return FileUtil.readFromFile(filename);
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture : " + e.getMessage());
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
                returnMenu.apply(null);
                return null;
            }
        }
    }
}
