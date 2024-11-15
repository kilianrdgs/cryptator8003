package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for Vigenere encryption method
 * Provides information about the Vigenere cipher algorithm
 */
public class VigenereHelpMenu {
    /**
     * Creates and returns the Vigenere help menu interface
     * @return Menu object configured with Vigenere help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                " __     ___                                  __  __      _   _               _ ",
                " \\ \\   / (_) __ _  ___ _ __   ___ _ __ ___  |  \\/  | ___| |_| |__   ___   __| |",
                "  \\ \\ / /| |/ _` |/ _ \\ '_ \\ / _ \\ '__/ _ \\ | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |",
                "   \\ V / | | (_| |  __/ | | |  __/ | |  __/ | |  | |  __/ |_| | | | (_) | (_| |",
                "    \\_/  |_|\\__, |\\___|_| |_|\\___|_|  \\___| |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|",
                "             |___/                                                               "
        );

        String helpText = 
                "Le chiffrement de Vigenère est une méthode de chiffrement par substitution\n" +
                "basée sur l'utilisation de plusieurs chiffrements de César différents.\n" +
                "Pour se faire, vous aurez besoin de deux mots différents : Celui que vous\n" +
                "souhaitez chiffrer, ainsi que celui qui vous servira de clé pour le chiffrer.\n" +
                "\n" +
                "Exemple :\n" +
                "Notons que vous voulez chiffrer le mot \"TATA\" avec la clé \"LAMA\".\n" +
                "T = 20e lettre de l'alphabet                L = 12e lettre de l'alphabet\n" +
                "A = 12e lettre de l'alphabet                A = 1e lettre de l'alphabet\n" +
                "T = 20e lettre de l'alphabet                M = 13e lettre de l'alphabet\n" +
                "A = 12e lettre de l'alphabet                A = 1e lettre de l'alphabet\n" +
                "\n" +
                "T+L = 20+12 = 32e lettre de l'alphabet; donc la 26e + 6e lettre de l'alphabet, soit F\n" +
                "A+A = 1+1 = 2e lettre de l'alphabet; soit B\n" +
                "T+M = 20+13 = 33e lettre de l'alphabet; donc la 26e + 7e lettre de l'alphabet, soit G\n" +
                "A+A = 1+1 = 2e lettre de l'alphabet; soit B\n" +
                "\n" +
                "Le mot \"TATA\" chiffré avec la clé \"LAMA\" donnera donc \"FBGB\".";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
