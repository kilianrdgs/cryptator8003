package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for MD5 hashing method
 * Provides simple explanation of the MD5 hashing algorithm
 */
public class MD5HelpMenu {
    /**
     * Creates and returns the MD5 help menu interface
     * @return Menu object configured with MD5 help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "     __  __ ____  ____  ",
                "    |  \\/  |  _ \\| ___| ",
                "    | |\\/| | | | |___ \\ ",
                "    | |  | | |_| |___) |",
                "    |_|  |_|____/|____/ "
        );

        String helpText = 
                "MD5 est comme une empreinte digitale pour vos messages. De la même façon que\n" +
                "chaque personne a une empreinte digitale unique, MD5 crée une signature unique\n" +
                "pour chaque message.\n" +
                "\n" +
                "Voici comment ça marche :\n" +
                "1. Prenez votre message, qu'il soit court ou long.\n" +
                "2. MD5 le transforme en une empreinte de 32 caractères, toujours de la même\n" +
                "   longueur, peu importe la taille du message original.\n" +
                "3. Cette empreinte est unique : si vous changez ne serait-ce qu'une lettre\n" +
                "   dans votre message, l'empreinte sera complètement différente.\n" +
                "\n" +
                "Pour rendre le système plus sûr, on ajoute :\n" +
                "- Un 'sel' (salt) : comme une pincée de sel unique pour chaque message\n" +
                "- Un 'poivre' (pepper) : un ingrédient secret commun à tous les messages\n" +
                "\n" +
                "Exemple :\n" +
                "Message : \"Bonjour\"\n" +
                "Sel généré : \"x7k9\"\n" +
                "Empreinte MD5 : \"a7b3f...\"\n" +
                "Résultat final : \"sel MD5 : x7k9-a7b3f...-pepper\"\n" +
                "\n" +
                "L'avantage de MD5 est qu'il est impossible de retrouver le message original\n" +
                "à partir de l'empreinte. C'est comme si vous aviez transformé un gâteau en\n" +
                "miettes : vous ne pouvez pas reconstruire le gâteau à partir des miettes !";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
