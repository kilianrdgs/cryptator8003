package org.example.menus;

import org.example.encrypting_methods.Vigenere;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for Vigenère encryption/decryption operations
 * Provides user interface for manual input or file import of messages
 */
public class VigenereMenus {
    private static boolean isEncrypting;
    private static final Vigenere vigenere = new Vigenere();

    /**
     * Creates and returns the Vigenère menu interface
     * @param forEncryption Boolean flag to determine if we're encrypting (true) or decrypting (false)
     * @return Menu object configured for Vigenère operations
     */
    public static Menu getVigenereMenu(boolean forEncryption) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "         __     ___                              ",
                "         \\ \\   / (_) __ _  ___ _ __   ___ _ __ ___",
                "          \\ \\ / /| |/ _` |/ _ \\ '_ \\ / _ \\ '__/ _ \\",
                "           \\ V / | | (_| |  __/ | | |  __/ | |  __/",
                "            \\_/  |_|\\__, |\\___|_| |_|\\___|_|  \\___|",
                "                    |___/                           "
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
        String message = MenuUtil.getMessageFromInput(manual, v -> getVigenereMenu(isEncrypting));
        if (message == null) return getVigenereMenu(isEncrypting);

        // Validate message contains only letters
        if (!message.matches("[a-zA-Z]+")) {
            System.out.println("\nErreur : Le message ne doit contenir que des lettres.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getVigenereMenu(isEncrypting);
        }

        // Get the key
        String key = MenuUtil.getInputFromUser("Entrez la clé de chiffrement (lettres uniquement) : ");
        
        // Validate key contains only letters
        if (!key.matches("[a-zA-Z]+")) {
            System.out.println("\nErreur : La clé ne doit contenir que des lettres.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getVigenereMenu(isEncrypting);
        }

        // Process the message
        String result;
        try {
            result = isEncrypting ?
                    vigenere.encrypt(message.toLowerCase(), key.toLowerCase()) :
                    vigenere.decrypt(message.toLowerCase(), key.toLowerCase());
            
            System.out.println("\nMessage " + (isEncrypting ? "chiffré" : "déchiffré") + " : " + result);
        } catch (Exception e) {
            System.out.println("Erreur lors du " + (isEncrypting ? "chiffrement" : "déchiffrement") + 
                             " : " + e.getMessage());
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();
            return getVigenereMenu(isEncrypting);
        }

        return MenuUtil.createSaveResultMenu(result, r -> getVigenereMenu(isEncrypting));
    }
}
