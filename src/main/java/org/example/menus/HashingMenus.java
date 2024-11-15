package org.example.menus;

import org.example.hashing_methods.MD5;
import org.example.hashing_methods.SHA256;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for Hashing operations
 * Provides user interface for MD5 and SHA-256 hashing methods
 */
public class HashingMenus {
    private static String currentMethod;

    /**
     * Creates and returns the main Hashing menu interface
     * @return Menu object configured for selecting hashing method
     */
    public static Menu getHashingMethodMenu() {
        Banner banner = Banner.create(
                "                    _   _           _     _             ",
                "                   | | | | __ _ ___| |__ (_)_ __   __ _ ",
                "                   | |_| |/ _` / __| '_ \\| | '_ \\ / _` |",
                "                   |  _  | (_| \\__ \\ | | | | | | | (_| |",
                "                   |_| |_|\\__,_|___/_| |_|_|_| |_|\\__, |",
                "                                                  |___/ "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Méthode MD5", () -> {
                    currentMethod = "MD5";
                    return getHashingMenu();
                })
                .addOption("2", "Méthode SHA-256", () -> {
                    currentMethod = "SHA-256";
                    return getHashingMenu();
                })
                .addOption("", "Retour au menu principal", () -> MainMenu.getMainMenu());
    }

    /**
     * Creates and returns the hashing operation menu interface
     * @return Menu object configured for hashing operations
     */
    public static Menu getHashingMenu() {
        Banner banner = Banner.create(
                "                    _   _           _     _             ",
                "                   | | | | __ _ ___| |__ (_)_ __   __ _ ",
                "                   | |_| |/ _` / __| '_ \\| | '_ \\ / _` |",
                "                   |  _  | (_| \\__ \\ | | | | | | | (_| |",
                "                   |_| |_|\\__,_|___/_| |_|_|_| |_|\\__, |",
                "                                                  |___/ ",
                "                   Méthode : " + currentMethod
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Saisie manuelle", () -> handleMessageInput(true))
                .addOption("2", "Importer depuis un fichier", () -> handleMessageInput(false))
                .addOption("", "Retour", () -> getHashingMethodMenu());
    }

    /**
     * Handles the message input process, whether manual or from file
     * @param manual Boolean flag indicating if input is manual (true) or from file (false)
     * @return Next menu to display
     */
    private static Menu handleMessageInput(boolean manual) {
        // Get the message
        String message = MenuUtil.getMessageFromInput(manual, v -> getHashingMenu());
        if (message == null) return getHashingMenu();

        // Process the message
        String result;
        try {
            if (currentMethod.equals("MD5")) {
                result = MD5.hash(message);
            } else {
                result = SHA256.hash(message);
            }
            
            System.out.println("\nMessage haché : " + result);
            
            return MenuUtil.createSaveResultMenu(result, r -> getHashingMenu());
            
        } catch (Exception e) {
            System.out.println("Erreur lors du hachage : " + e.getMessage());
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getHashingMenu();
        }
    }
}
