package org.example.menus;

import org.example.encrypting_methods.RC4;
import org.example.utils.CommonUtil;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

import java.nio.charset.StandardCharsets;

/**
 * Menu handler for RC4 encryption/decryption operations
 */
public class RC4Menus {
    protected static boolean isEncrypting;
    private static final RC4 rc4 = new RC4();

    /**
     * Creates and returns the RC4 menu interface
     * @param forEncryption Boolean flag to determine if we're encrypting (true) or decrypting (false)
     * @param chainMode Boolean flag to indicate if we're in chain mode
     * @param chainMessage Current message when in chain mode (can be null)
     * @return Menu object configured for RC4 operations
     */
    public static Menu getRC4Menu(boolean forEncryption, boolean chainMode, String chainMessage) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "                   ____   ____ _  _",
                "                  |  _ \\ / ___| || |",
                "                  | |_) | |   | || |_",
                "                  |  _ <| |___|__   _|",
                "                  |_| \\_\\\\____|  |_|"
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
                "                   ____   ____ _  _",
                "                  |  _ \\ / ___| || |",
                "                  | |_) | |   | || |_",
                "                  |  _ <| |___|__   _|",
                "                  |_| \\_\\\\____|  |_|"
        );

        String title = "\nMessage actuel : " + message;

        return new Menu()
                .setBanner(banner)
                .setTitle(title)
                .addOption("1", "Entrer la clé", () -> processWithKey(message, chainMode))
                .addOption("", "Retour", () -> chainMode ? 
                        ChainMenus.getMethodSelectionMenu() :
                        getRC4Menu(isEncrypting, false, null));
    }

    private static Menu handleMessageInput(boolean manual, boolean chainMode) {
        String prompt = isEncrypting ? "Message à chiffrer : " : "Message chiffré (en hexadécimal) : ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getRC4Menu(isEncrypting, chainMode, null));
        if (message == null) return getRC4Menu(isEncrypting, chainMode, null);

        return getKeyInputMenu(message, chainMode);
    }

    private static Menu processWithKey(String message, boolean chainMode) {
        // Get the key
        String key = MenuUtil.getInputFromUser("Clé de chiffrement : ");

        try {
            String result;
            if (isEncrypting) {
                byte[] encryptedBytes = rc4.encrypt(
                    message.getBytes(StandardCharsets.UTF_8),
                    key.getBytes(StandardCharsets.UTF_8)
                );
                result = CommonUtil.bytesToHex(encryptedBytes);
            } else {
                byte[] decryptedBytes = rc4.decrypt(
                    CommonUtil.hexToBytes(message),
                    key.getBytes(StandardCharsets.UTF_8)
                );
                result = new String(decryptedBytes, StandardCharsets.UTF_8);
            }
            
            System.out.println("\nMessage " + (isEncrypting ? "chiffré" : "déchiffré") + " : " + result);
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            MenuUtil.waitForEnter();

            if (chainMode) {
                ChainMenus.setCurrentMessage(result);
                return ChainMenus.getMethodSelectionMenu();
            } else {
                return MenuUtil.createSaveResultMenu(result, r -> getRC4Menu(isEncrypting, false, null));
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
