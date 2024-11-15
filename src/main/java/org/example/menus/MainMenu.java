package org.example.menus;

import org.example.utils.menu.Banner;
import org.example.utils.menu.Menu;
import org.example.menus.help_menus.HelpMenu;

/**
 * Main menu handler for the application
 * Provides the entry point for all encryption, decryption and help operations
 */
public class MainMenu {
    /**
     * Creates and returns the main menu interface
     * @return Menu object configured with all main options
     */
    public static Menu getMainMenu() {
        Banner banner = Banner.create(
                "   ____                  _        _                ___   ___   ___ _____ ",
                "  / ___|_ __ _   _ _ __ | |_ __ _| |_ ___  _ __   ( _ ) / _ \\ / _ \\___ / ",
                " | |   | '__| | | | '_ \\| __/ _` | __/ _ \\| '__|  / _ \\| | | | | | ||_ \\ ",
                " | |___| |  | |_| | |_) | || (_| | || (_) | |    | (_) | |_| | |_| |__) |",
                "  \\____|_|   \\__, | .__/ \\__\\__,_|\\__\\___/|_|     \\___/ \\___/ \\___/____/ ",
                "             |___/|_|                                                    "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Chiffrer un message", EncryptionMenus::getEncryptionMenu)
                .addOption("2", "Déchiffrer un message", DecryptionMenus::getDecryptionMenu)
                .addOption("3", "Hacher un message", HashingMenus::getHashingMethodMenu)
                .addOption("4", "Chiffrer, puis hacher un message", () -> null)
                .addOption("5", "Succéder plusieurs chiffrements", () -> null)
                .addOption("6", "Besoin d'aide ?", HelpMenu::getHelpMenu)
                .addOption("", "Quitter", () -> null);
    }
}
