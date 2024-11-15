package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for Enigma encryption method
 * Provides information about the Enigma machine algorithm
 */
public class EnigmaHelpMenu {
    /**
     * Creates and returns the Enigma help menu interface
     * @return Menu object configured with Enigma help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                " _____       _                         __  __            _     _            ",
                "| ____|_ __ (_) __ _ _ __ ___   __ _  |  \\/  | __ _  ___| |__ (_)_ __   ___ ",
                "|  _| | '_ \\| |/ _` | '_ ` _ \\ / _` | | |\\/| |/ _` |/ __| '_ \\| | '_ \\ / _ \\",
                "| |___| | | | | (_| | | | | | | (_| | | |  | | (_| | (__| | | | | | | |  __/",
                "|_____|_| |_|_|\\__, |_| |_| |_|\\__,_| |_|  |_|\\__,_|\\___|_| |_|_|_| |_|\\___|",
                "               |___/                                                        "
        );

        String helpText = 
                "La machine Enigma est une machine de chiffrement électromécanique utilisée par les\n" +
                "forces armées allemandes pendant la Seconde Guerre mondiale. Elle a été inventée par\n" +
                "l'ingénieur allemand Arthur Scherbius à la fin de la Première Guerre mondiale.\n" +
                "\n" +
                "La machine Enigma, en informatique, est un algorithme de chiffrement symétrique\n" +
                "utilisé pour chiffrer et déchiffrer des messages. Il est basé sur un réseau de\n" +
                "substitutions.\n" +
                "\n" +
                "Exemple :\n" +
                "Notons que vous souhaitez écrire le mot 'HELLO'. En utilisant la machine Enigma,\n" +
                "vous obtiendrez un message chiffré, tel que 'XKJLQ', selon les réglages des rotors.";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
