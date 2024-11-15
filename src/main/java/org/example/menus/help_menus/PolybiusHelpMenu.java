package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for Polybius encryption method
 * Provides information about the Polybius square cipher algorithm
 */
public class PolybiusHelpMenu {
    /**
     * Creates and returns the Polybius help menu interface
     * @return Menu object configured with Polybius help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "  ____       _       _     _             __  __      _   _               _ ",
                " |  _ \\ ___ | |_   _| |__ (_)_   _ ___  |  \\/  | ___| |_| |__   ___   __| |",
                " | |_) / _ \\| | | | | '_ \\| | | | / __| | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |",
                " |  __/ (_) | | |_| | |_) | | |_| \\__ \\ | |  | |  __/ |_| | | | (_) | (_| |",
                " |_|   \\___/|_|\\__, |_.__/|_|\\__,_|___/ |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|",
                "               |___/                                                        "
        );

        StringBuilder grid = new StringBuilder();
        grid.append("  | 1 2 3 4 5\n");
        grid.append("--+-----------\n");
        grid.append("1 | A B C D E\n");
        grid.append("2 | F G H I J\n");
        grid.append("3 | K L M N O\n");
        grid.append("4 | P Q R S T\n");
        grid.append("5 | U V X Y Z\n");

        String helpText = 
                "Le chiffrement par le carré de Polybe est une méthode de chiffrement\n" +
                "par substitution basée sur l'utilisation d'un carré de Polybe.\n" +
                "Ce carré est une table de 5x5 contenant l'alphabet, sans la lettre W, dans\n" +
                "notre cas. Chaque lettre est représentée par ses coordonnées dans le carré.\n" +
                "Le W sera représenté par deux lettres V de suite.\n" +
                "\n" +
                "Exemple :\n" +
                grid.toString() + "\n" +
                "Notons que si vous voulez chiffrer le mot \"EXEMPLE\" en utilisant le chiffre des\n" +
                "abscisses en premier, puis celui des ordonnées, vous obtiendrez le chiffrement\n" +
                "suivant : E = 15 car étant aux coordonnées (1,5), X = 53 car étant aux\n" +
                "coordonnées (5,3), E = 15, M = 33, P = 41, L = 32 et E = 15.\n" +
                "\n" +
                "Le mot \"EXEMPLE\" sera donc chiffré en \"15531533413215\".\n" +
                "\n" +
                "Le mot WAGON, lui, sera chiffré en \"525211223534\". 5252 = VV = W, 11 = A, 22 = G,\n" +
                "35 = O et 34 = N.";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
