package org.example.menus.help_menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;

/**
 * Help menu handler for SHA-256 hashing method
 * Provides simple explanation of the SHA-256 hashing algorithm
 */
public class SHA256HelpMenu {
    /**
     * Creates and returns the SHA-256 help menu interface
     * @return Menu object configured with SHA-256 help information
     */
    public static Menu getHelpMenu() {
        Banner banner = Banner.create(
                "     ____  _   _    _    ____  ____   __  ",
                "    / ___|| | | |  / \\  |___ \\| ___| / /  ",
                "    \\___ \\| |_| | / _ \\   __) |___ \\/ _ \\ ",
                "     ___) |  _  |/ ___ \\ / __/ ___) | (_) |",
                "    |____/|_| |_/_/   \\_\\_____|____/ \\___/ "
        );

        String helpText = 
                "SHA-256 est comme un broyeur de documents très sophistiqué. Imaginez que vous\n" +
                "ayez un document que vous voulez transformer en confettis d'une manière très\n" +
                "précise et reproductible.\n" +
                "\n" +
                "Voici comment ça marche :\n" +
                "1. Prenez votre message, qu'il soit court ou long.\n" +
                "2. SHA-256 le transforme en une empreinte de 64 caractères, toujours de la\n" +
                "   même longueur, peu importe la taille du message original.\n" +
                "3. Cette empreinte est unique et plus longue que MD5, ce qui la rend encore\n" +
                "   plus sûre.\n" +
                "\n" +
                "Pour rendre le système plus sûr, on ajoute comme pour MD5 :\n" +
                "- Un 'sel' (salt) : un code unique généré pour chaque message\n" +
                "- Un 'poivre' (pepper) : un ingrédient secret commun à tous les messages\n" +
                "\n" +
                "Exemple :\n" +
                "Message : \"Bonjour\"\n" +
                "Sel généré : \"y8m2\"\n" +
                "Empreinte SHA-256 : \"b4f9c...\"\n" +
                "Résultat final : \"sel SHA-256 : y8m2-b4f9c...-pepper\"\n" +
                "\n" +
                "La différence principale avec MD5 est que SHA-256 est plus récent et crée une\n" +
                "empreinte plus longue, ce qui le rend encore plus sûr. C'est comme si au lieu\n" +
                "d'avoir un broyeur simple, vous aviez un super-broyeur qui découpe les documents\n" +
                "en morceaux encore plus petits !";

        return new Menu()
                .setBanner(banner)
                .setBody(helpText)
                .addOption("", "Retour", () -> HelpMenu.getHelpMenu());
    }
}
