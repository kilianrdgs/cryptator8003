package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for RC4 encryption method
 * Provides simple explanation of the RC4 stream cipher algorithm
 */
public class RC4HelpMenu {
    /**
     * Creates and returns the RC4 help menu interface
     * @return Menu object configured with RC4 help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "     ____   ____ _  _",
                "    |  _ \\ / ___| || |",
                "    | |_) | |   | || |_",
                "    |  _ <| |___|__   _|",
                "    |_| \\_\\\\____|  |_|"
        );

        String helpText = 
                "RC4 (Rivest Cipher 4) est une méthode de chiffrement qui fonctionne comme\n" +
                "un mélangeur de cartes très sophistiqué. Imaginez que vous ayez un jeu de\n" +
                "cartes et que vous vouliez cacher un message.\n" +
                "\n" +
                "Voici comment ça marche :\n" +
                "1. Vous commencez avec un mot secret (la clé) qui détermine comment mélanger\n" +
                "   les cartes.\n" +
                "2. À chaque lettre de votre message, RC4 utilise ce mélange pour créer un\n" +
                "   nouveau nombre.\n" +
                "3. Ce nombre est combiné avec votre lettre pour la rendre illisible.\n" +
                "\n" +
                "L'avantage de RC4 est sa simplicité et sa rapidité. C'est comme si vous aviez\n" +
                "un mélangeur de cartes automatique qui crée un mélange différent pour chaque\n" +
                "lettre de votre message, rendant très difficile pour quelqu'un de deviner\n" +
                "votre message sans connaître votre mot secret.\n" +
                "\n" +
                "Exemple :\n" +
                "Si vous voulez chiffrer le mot \"BONJOUR\" avec la clé \"SECRET\", RC4 va\n" +
                "créer une série de nombres uniques basés sur \"SECRET\", puis les combiner\n" +
                "avec chaque lettre de \"BONJOUR\" pour créer un message chiffré qui\n" +
                "ressemblera à du charabia pour quiconque ne connaît pas la clé.";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
