package org.example.menus;

import org.example.encrypting_methods.RC4;
import org.example.utils.CommonUtil;
import org.example.utils.menu.Menu;
import org.example.utils.menu.Banner;
import org.example.utils.menu.MenuUtil;

import java.nio.charset.StandardCharsets;

public class RC4Menus {
    private static boolean isEncrypting;
    private static final RC4 rc4 = new RC4();

    public static Menu getRC4Menu(boolean forEncryption) {
        isEncrypting = forEncryption;

        Banner banner = Banner.create(
                "                   ____   ____ _  _",
                "                  |  _ \\ / ___| || |",
                "                  | |_) | |   | || |_",
                "                  |  _ <| |___|__   _|",
                "                  |_| \\_\\\\____|  |_|"
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

    private static Menu handleMessageInput(boolean manual) {
        // Get the message
        String prompt = isEncrypting ? "Message à chiffrer : " : "Message chiffré (en hexadécimal) : ";
        String message = MenuUtil.getMessageFromInput(manual, v -> getRC4Menu(isEncrypting));
        if (message == null) return getRC4Menu(isEncrypting);

        // Get the key
        String key = MenuUtil.getInputFromUser("Clé de chiffrement : ");

        // Process the message
        String result;
        try {
            if (isEncrypting) {
                byte[] encryptedBytes = rc4.encrypt(
                    message.getBytes(StandardCharsets.UTF_8),
                    key.getBytes(StandardCharsets.UTF_8)
                );
                result = CommonUtil.bytesToHex(encryptedBytes);
                System.out.println("\nMessage chiffré (en hexadécimal) : " + result);
            } else {
                byte[] decryptedBytes = rc4.decrypt(
                    CommonUtil.hexToBytes(message),
                    key.getBytes(StandardCharsets.UTF_8)
                );
                result = new String(decryptedBytes, StandardCharsets.UTF_8);
                System.out.println("\nMessage déchiffré : " + result);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du " + (isEncrypting ? "chiffrement" : "déchiffrement") + 
                             " : " + e.getMessage());
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            return getRC4Menu(isEncrypting);
        }

        return MenuUtil.createSaveResultMenu(result, r -> getRC4Menu(isEncrypting));
    }
}
