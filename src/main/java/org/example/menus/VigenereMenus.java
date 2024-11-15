package org.example.menus;

import org.example.encrypting_methods.VigenereMethod;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for Vigenere encryption/decryption operations
 * Provides user interface for manual input or file import of messages
 */
public class VigenereMenus {
    private static boolean isEncrypting;

    /**
     * Creates and returns the Vigenere menu interface
     * @param forEncryption Boolean flag to determine if we're encrypting (true) or decrypting (false)
     * @return Menu object configured for Vigenere operations
     */
    public static Menu getVigenereMenu(boolean forEncryption) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "        __     ___                                           ",
                "        \\ \\   / (_) __ _  ___ _ __   ___ _ __ ___          ",
                "         \\ \\ / /| |/ _` |/ _ \\ '_ \\ / _ \\ '__/ _ \\         ",
                "          \\ V / | | (_| |  __/ | | |  __/ | |  __/         ",
                "           \\_/  |_|\\__, |\\___|_| |_|\\___|_|  \\___|         ",
                "                   |___/                                     "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Manual input", () -> handleMessageInput(true))
                .addOption("2", "Import from file", () -> handleMessageInput(false))
                .addOption("", "Back", () -> isEncrypting ?
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
        String prompt = isEncrypting ? "Message to encrypt: " : "Encrypted message: ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getVigenereMenu(isEncrypting));
        if (message == null) return getVigenereMenu(isEncrypting);

        // Validate message contains only letters
        if (!message.matches("[a-zA-Z]+")) {
            System.out.println("\nError: Message must contain only letters.");
            System.out.println("\nPress Enter to continue...");
            MenuUtil.waitForEnter();
            return getVigenereMenu(isEncrypting);
        }

        // Get the key
        String key = MenuUtil.getInputFromUser("Encryption key: ");
        
        // Validate key contains only letters
        if (!key.matches("[a-zA-Z]+")) {
            System.out.println("\nError: Key must contain only letters.");
            System.out.println("\nPress Enter to continue...");
            MenuUtil.waitForEnter();
            return getVigenereMenu(isEncrypting);
        }

        // Process the message
        String result;
        try {
            if (isEncrypting) {
                VigenereMethod.vigenereEncryption(message, key);
                System.out.println("\nEncrypted message: " + result);
            } else {
                VigenereMethod.vigenereDecryption(message, key);
                System.out.println("\nDecrypted message: " + result);
            }
        } catch (Exception e) {
            System.out.println("Error during " + (isEncrypting ? "encryption" : "decryption") + 
                             ": " + e.getMessage());
            System.out.println("\nPress Enter to continue...");
            MenuUtil.waitForEnter();
            return getVigenereMenu(isEncrypting);
        }

        return MenuUtil.createSaveResultMenu(result, r -> getVigenereMenu(isEncrypting));
    }
}
