package org.example.menus;

import org.example.encrypting_methods.Enigma;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for Enigma encryption/decryption operations
 */
public class EnigmaMenus {
    protected static boolean isEncrypting;

    /**
     * Creates and returns the Enigma menu interface
     * @param forEncryption Boolean flag to determine if we're encrypting (true) or decrypting (false)
     * @param chainMode Boolean flag to indicate if we're in chain mode
     * @param chainMessage Current message when in chain mode (can be null)
     * @return Menu object configured for Enigma operations
     */
    public static Menu getEnigmaMenu(boolean forEncryption, boolean chainMode, String chainMessage) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "    ______      _                      ",
                "   |  ____|    (_)                     ",
                "   | |__   _ __  _  __ _ _ __ ___   __ ",
                "   |  __| | '_ \\| |/ _` | '_ ` _ \\ / _|",
                "   | |____| | | | | (_| | | | | | | (_|",
                "   |______|_| |_|_|\\__, |_| |_| |_|\\__|",
                "                    __/ |              ",
                "                   |___/               "
        );

        // If we're in chain mode and have a message, go straight to key input
        if (chainMode && chainMessage != null) {
            return getKeyInputMenu(chainMessage, chainMode);
        }

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Saisie manuelle", () -> handleMessageInput(true, chainMode))
                .addOption("2", "Importer depuis un fichier", () -> handleMessageInput(false, chainMode))
                .addOption("", "Retour", () -> isEncrypting ?
                        EncryptionMenus.getEncryptionMenu() :
                        DecryptionMenus.getDecryptionMenu()
                );
    }

    private static Menu getKeyInputMenu(String message, boolean chainMode) {
        Banner banner = Banner.create(
                "    ______      _                      ",
                "   |  ____|    (_)                     ",
                "   | |__   _ __  _  __ _ _ __ ___   __ ",
                "   |  __| | '_ \\| |/ _` | '_ ` _ \\ / _|",
                "   | |____| | | | | (_| | | | | | | (_|",
                "   |______|_| |_|_|\\__, |_| |_| |_|\\__|",
                "                    __/ |              ",
                "                   |___/               "
        );

        String title = "\nMessage actuel : " + message;

        return new Menu()
                .setBanner(banner)
                .setTitle(title)
                .addOption("1", "Entrer la clé", () -> processWithKey(message, chainMode))
                .addOption("", "Retour", () -> chainMode ? 
                        ChainMenus.getMethodSelectionMenu() :
                        getEnigmaMenu(isEncrypting, false, null));
    }

    private static Menu handleMessageInput(boolean manual, boolean chainMode) {
        String prompt = isEncrypting ? "Message à chiffrer : " : "Message chiffré : ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getEnigmaMenu(isEncrypting, chainMode, null));
        if (message == null) return getEnigmaMenu(isEncrypting, chainMode, null);

        // Validate message contains only letters
        if (!message.matches("[a-zA-Z]+")) {
            System.out.println("\nErreur : Le message ne doit contenir que des lettres.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getEnigmaMenu(isEncrypting, chainMode, null);
        }

        return getKeyInputMenu(message, chainMode);
    }

    private static Menu processWithKey(String message, boolean chainMode) {
        // Get the key
        String key = MenuUtil.getInputFromUser("Entrez la clé de chiffrement (lettres uniquement) : ");
        
        // Validate key contains only letters
        if (!key.matches("[a-zA-Z]+")) {
            System.out.println("\nErreur : La clé ne doit contenir que des lettres.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getKeyInputMenu(message, chainMode);
        }

        try {
            if (isEncrypting) {
                Enigma.crypt(message.toLowerCase(), key.toLowerCase());
            } else {
                Enigma.decrypt(message.toLowerCase(), key.toLowerCase());
            }
            
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();

            if (chainMode) {
                ChainMenus.setCurrentMessage(message); // Using original message since Enigma prints directly
                return ChainMenus.getMethodSelectionMenu();
            } else {
                return getEnigmaMenu(isEncrypting, false, null);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du " + (isEncrypting ? "chiffrement" : "déchiffrement") + 
                             " : " + e.getMessage());
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getKeyInputMenu(message, chainMode);
        }
    }
}
