package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for Caesar encryption method
 * Provides information about the Caesar cipher algorithm
 */
public class CaesarHelpMenu {
    /**
     * Creates and returns the Caesar help menu interface
     * @return Menu object configured with Caesar help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "  ____                            __  __      _   _               _ ",
                " / ___|___  __ _ ___  __ _ _ __  |  \\/  | ___| |_| |__   ___   __| |",
                "| |   / _ \\/ _` / __|/ _` | '__| | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |",
                "| |__|  __/ (_| \\__ \\ (_| | |    | |  | |  __/ |_| | | | (_) | (_| |",
                " \\____\\___|\\__,_|___/\\__,_|_|    |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|"
        );

        String helpText = 
                "Le chiffrement César est une méthode de chiffrement que l'on appelle\n" +
                "chiffrement par rotation. Le principe est de décaler chaque lettre d'un\n" +
                "certain nombre de positions dans l'alphabet. Par exemple, avec un décalage\n" +
                "de 3 positions, en référence à la première lettre du nom de César, le C\n" +
                "étant la troisième lettre de l'alphabet.\n" +
                "\n" +
                "Exemple :\n" +
                "Avec un décalage de 3 (trois lettres devant), la lettre A devient la lettre D.";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
