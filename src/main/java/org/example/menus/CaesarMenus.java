package org.example.menus;

import org.example.encrypting_methods.Caesar;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for Caesar encryption/decryption operations
 * Provides user interface for manual input or file import of messages
 */
public class CaesarMenus {
    protected static boolean isEncrypting;
    private static final Caesar caesar = new Caesar();

    /**
     * Creates and returns the Caesar menu interface
     * @param forEncryption Boolean flag to determine if we're encrypting (true) or decrypting (false)
     * @param chainMode Boolean flag to indicate if we're in chain mode
     * @param chainMessage Current message when in chain mode (can be null)
     * @return Menu object configured for Caesar operations
     */
    public static Menu getCaesarMenu(boolean forEncryption, boolean chainMode, String chainMessage) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "          ____                            ",
                "         / ___|__ _  ___  ___  __ _ _ __ ",
                "        | |   / _` |/ _ \\/ __|/ _` | '__|",
                "        | |__| (_| |  __/\\__ \\ (_| | |   ",
                "         \\____\\__,_|\\___||___/\\__,_|_|   "
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
                "          ____                            ",
                "         / ___|__ _  ___  ___  __ _ _ __ ",
                "        | |   / _` |/ _ \\/ __|/ _` | '__|",
                "        | |__| (_| |  __/\\__ \\ (_| | |   ",
                "         \\____\\__,_|\\___||___/\\__,_|_|   "
        );

        String title = "\nMessage actuel : " + message;

        return new Menu()
                .setBanner(banner)
                .setTitle(title)
                .addOption("1", "Entrer la clé", () -> processWithKey(message, chainMode))
                .addOption("", "Retour", () -> chainMode ? 
                        ChainMenus.getMethodSelectionMenu() :
                        getCaesarMenu(isEncrypting, false, null));
    }

    private static Menu handleMessageInput(boolean manual, boolean chainMode) {
        String prompt = isEncrypting ? "Message à chiffrer : " : "Message chiffré : ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getCaesarMenu(isEncrypting, chainMode, null));
        if (message == null) return getCaesarMenu(isEncrypting, chainMode, null);

        // Validate message contains only letters
        if (!message.matches("[a-zA-Z]+")) {
            System.out.println("\nErreur : Le message ne doit contenir que des lettres.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getCaesarMenu(isEncrypting, chainMode, null);
        }

        return getKeyInputMenu(message, chainMode);
    }

    private static Menu processWithKey(String message, boolean chainMode) {
        // Get the shift key
        String keyInput = MenuUtil.getInputFromUser("Entrez la clé de décalage (1-25) : ");
        
        // Validate and parse the key
        int key;
        try {
            key = Integer.parseInt(keyInput);
            if (key < 1 || key > 25) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nErreur : La clé doit être un nombre entre 1 et 25.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getKeyInputMenu(message, chainMode);
        }

        try {
            String result = isEncrypting ?
                    caesar.encrypt(message.toLowerCase(), key) :
                    caesar.decrypt(message.toLowerCase(), key);
            
            System.out.println("\nMessage " + (isEncrypting ? "chiffré" : "déchiffré") + " : " + result);
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();

            if (chainMode) {
                ChainMenus.setCurrentMessage(result);
                return ChainMenus.getMethodSelectionMenu();
            } else {
                return MenuUtil.createSaveResultMenu(result, r -> getCaesarMenu(isEncrypting, false, null));
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
