package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for LFSR encryption method
 * Provides information about the Linear Feedback Shift Register algorithm
 */
public class LFSRHelpMenu {
    /**
     * Creates and returns the LFSR help menu interface
     * @return Menu object configured with LFSR help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "      _       _____ ____   ____      __  __      _   _               _ ",
                "     | |     |  ___/ ___| |  _ \\    |  \\/  | ___| |_| |__   ___   __| |",
                "     | |     | |_  \\___ \\ | |_) |   | |\\/| |/ _ \\ __| '_ \\ / _ \\ / _` |",
                "     | |___ _|  _|  ___) ||  _ < _  | |  | |  __/ |_| | | | (_) | (_| |",
                "     |_____(_)_|(_)|____(_)_| \\_(_) |_|  |_|\\___|\\__|_| |_|\\___/ \\__,_|"
        );

        String helpText = 
                "Le LFSR, ou Linear Feedback Shift Register, est un registre à décalage à rétroaction\n" +
                "linéaire. Il est utilisé en cryptographie pour générer des séquences pseudo-aléatoires.\n" +
                "Le LFSR est composé d'une graine (seed), et d'une fonction de transformation.\n" +
                "\n" +
                "La fonction de transformation prend en entrée les bits de la graine, et génère un nouveau\n" +
                "bit en sortie. Ce nouveau bit est ensuite ajouté à la graine, et le bit le plus ancien est\n" +
                "décalé d'une position.\n" +
                "\n" +
                "Exemple :\n" +
                "Notons que vous ayez un LFSR de 4 bits avec une graine de 1010. La fonction de transformation\n" +
                "est la suivante : Sur un LFSR de 4 bits, les 2e et 4e sont additionnés pour générer le nouveau\n" +
                "bit. Alors, en prenant les 2e et 4e bits, on passera de 1010 à 0100. Car 0+0 = 0, alors on\n" +
                "ajoute le dernier bit au LFSR, en décalant d'un cran vers la gauche, et retirant le premier bit.\n" +
                "Puis, on répète l'opération. 0100 deviendra 1001, puis 0011, puis 0111, etc.";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
