package org.example.menus;

import org.example.encrypting_methods.CeasarMethod;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

/**
 * Menu handler for Caesar encryption/decryption operations
 * Provides user interface for manual input or file import of messages
 */
public class CaesarMenus {
    private static boolean isEncrypting;

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
        String message = MenuUtil.getMessageFromInput(manual, v -> getCaesarMenu(isEncrypting));
        if (message == null) return getCaesarMenu(isEncrypting);

        // Validate message contains only letters
        if (!message.matches("[a-zA-Z]+")) {
            System.out.println("\nError: Message must contain only letters.");
            System.out.println("\nPress Enter to continue...");
            MenuUtil.waitForEnter();
            return getCaesarMenu(isEncrypting);
        }

        // Get the shift key
        String keyInput = MenuUtil.getInputFromUser("Enter shift key (1-25): ");
        
        // Validate and parse the key
        int key;
        try {
            key = Integer.parseInt(keyInput);
            if (key < 1 || key > 25) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError: Key must be a number between 1 and 25.");
            System.out.println("\nPress Enter to continue...");
            MenuUtil.waitForEnter();
            return getCaesarMenu(isEncrypting);
        }

        // Process the message
        try {
            if (isEncrypting) {
                CeasarMethod.ceasarEncryption(message.toLowerCase(), key);
                System.out.println("\nMessage encrypted successfully!");
            } else {
                CeasarMethod.ceasarDecryption(message.toLowerCase(), key);
                System.out.println("\nMessage decrypted successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error during " + (isEncrypting ? "encryption" : "decryption") + 
                             ": " + e.getMessage());
            System.out.println("\nPress Enter to continue...");
            MenuUtil.waitForEnter();
            return getCaesarMenu(isEncrypting);
        }

        System.out.println("\nPress Enter to continue...");
        MenuUtil.waitForEnter();
        return getCaesarMenu(isEncrypting);
    }
}
