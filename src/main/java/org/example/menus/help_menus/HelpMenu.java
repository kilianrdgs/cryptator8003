package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.menus.MainMenu;

/**
 * Main help menu handler
 * Provides access to help information for all encryption and hashing methods
 */
public class HelpMenu {
    /**
     * Creates and returns the help menu interface
     * @return Menu object configured with all help options
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "                    _    _ _____ _     ____  ",
                "                   | |  | | ____| |   |  _ \\ ",
                "                   | |__| |  _| | |   | |_) |",
                "                   |  __  | |___| |___|  __/ ",
                "                   |_|  |_|_____|_____|_|    "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Aide sur le chiffrement de César", CaesarHelpMenu::getHelpMenu)
                .addOption("2", "Aide sur le chiffrement de Vigenère", VigenereHelpMenu::getHelpMenu)
                .addOption("3", "Aide sur le chiffrement de Polybe", PolybiusHelpMenu::getHelpMenu)
                .addOption("4", "Aide sur le chiffrement RC4", RC4HelpMenu::getHelpMenu)
                .addOption("5", "Aide sur le chiffrement Enigma", EnigmaHelpMenu::getHelpMenu)
                .addOption("6", "Aide sur le chiffrement LFSR", LFSRHelpMenu::getHelpMenu)
                .addOption("7", "Aide sur le hachage MD5", MD5HelpMenu::getHelpMenu)
                .addOption("8", "Aide sur le hachage SHA-256", SHA256HelpMenu::getHelpMenu)
                .addOption("", "Retour", MainMenu::getMainMenu);
    }
}
