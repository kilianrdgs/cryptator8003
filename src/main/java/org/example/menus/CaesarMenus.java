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
    private static boolean isEncrypting;
    private static final Caesar caesar = new Caesar();

    /**
     * Creates and returns the Caesar menu interface
     * @param forEncryption Boolean flag to determine if we're encrypting (true) or decrypting (false)
     * @return Menu object configured for Caesar operations
     */
    public static Menu getCaesarMenu(boolean forEncryption) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "          ____                            ",
                "         / ___|__ _  ___  ___  __ _ _ __ ",
                "        | |   / _` |/ _ \\/ __|/ _` | '__|",
                "        | |__| (_| |  __/\\__ \\ (_| | |   ",
                "         \\____\\__,_|\\___||___/\\__,_|_|   "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Saisie manuelle", () -> handleMessageInput(true))
                .addOption("2", "Importer depuis un fichier", () -> handleMessageInput(false))
                .addOption("", "Retour", () -> isEncrypting ?
                        EncryptionMenus.getEncryptionMenu() :
                        DecryptionMenus.getDecryptionMenu()
                );
    }

    /**
     * Handles the message input process, whether manual or from file
     * @param manual Boolean flag indicating if input is manual (true) or from file (false)
     * @return Next menu to display
     */
    private static Menu handleMessageInput(boolean manual) {
        // Get the message
        String prompt = isEncrypting ? "Message à chiffrer : " : "Message chiffré : ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getCaesarMenu(isEncrypting));
        if (message == null) return getCaesarMenu(isEncrypting);

        // Validate message contains only letters
        if (!message.matches("[a-zA-Z]+")) {
            System.out.println("\nErreur : Le message ne doit contenir que des lettres.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getCaesarMenu(isEncrypting);
        }

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
            return getCaesarMenu(isEncrypting);
        }

        // Process the message
        String result;
        try {
            result = isEncrypting ?
                    caesar.encrypt(message.toLowerCase(), key) :
                    caesar.decrypt(message.toLowerCase(), key);
            
            System.out.println("\nMessage " + (isEncrypting ? "chiffré" : "déchiffré") + " : " + result);
        } catch (Exception e) {
            System.out.println("Erreur lors du " + (isEncrypting ? "chiffrement" : "déchiffrement") + 
                             " : " + e.getMessage());
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getCaesarMenu(isEncrypting);
        }

        return MenuUtil.createSaveResultMenu(result, r -> getCaesarMenu(isEncrypting));
    }
}
