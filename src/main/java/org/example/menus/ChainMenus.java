package org.example.menus;

import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for chained encryption/decryption operations
 */
public class ChainMenus {
    private static boolean isEncrypting;
    private static String currentMessage;

    public static Menu getChainMenu(boolean forEncryption) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "             ____ _           _                  ",
                "            / ___| |__   __ _(_)_ __   ___      ",
                "           | |   | '_ \\ / _` | | '_ \\ / _ \\     ",
                "           | |___| | | | (_| | | | | |  __/     ",
                "            \\____|_| |_|\\__,_|_|_| |_|\\___|     "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Saisie manuelle", () -> handleMessageInput(true))
                .addOption("2", "Importer depuis un fichier", () -> handleMessageInput(false))
                .addOption("", "Retour", MainMenu::getMainMenu);
    }

    private static Menu handleMessageInput(boolean manual) {
        String prompt = isEncrypting ? "Message à chiffrer : " : "Message chiffré : ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getChainMenu(isEncrypting));
        if (message == null) return getChainMenu(isEncrypting);

        currentMessage = message;
        return getMethodSelectionMenu();
    }

    public static Menu getMethodSelectionMenu() {
        Banner banner = Banner.create(
                "             ____ _           _                  ",
                "            / ___| |__   __ _(_)_ __   ___      ",
                "           | |   | '_ \\ / _` | | '_ \\ / _ \\     ",
                "           | |___| | | | (_| | | | | |  __/     ",
                "            \\____|_| |_|\\__,_|_|_| |_|\\___|     "
        );

        String title = "\n Choisissez la prochaine méthode de " + (isEncrypting ? "chiffrement" : "déchiffrement");
        String body = "\nMessage actuel : " + currentMessage;

        return new Menu()
                .setBanner(banner)
                .setTitle(title)
                .setBody(body)
                .addOption("1", "César", () -> CaesarMenus.getCaesarMenu(isEncrypting, true, currentMessage))
                .addOption("2", "Vigenère", () -> VigenereMenus.getVigenereMenu(isEncrypting, true, currentMessage))
                .addOption("3", "Carré de Polybe", () -> PolybiusMenus.getPolybiusMenu(isEncrypting, true, currentMessage))
                .addOption("4", "RC4", () -> RC4Menus.getRC4Menu(isEncrypting, true, currentMessage))
                .addOption("5", "Terminer et sauvegarder", () -> MenuUtil.createSaveResultMenu(currentMessage, r -> MainMenu.getMainMenu()))
                .addOption("", "Retour", MainMenu::getMainMenu);
    }

    // Method to update the current message after each encryption/decryption
    public static void setCurrentMessage(String message) {
        currentMessage = message;
    }

    // Method to get the current message
    public static String getCurrentMessage() {
        return currentMessage;
    }
}
