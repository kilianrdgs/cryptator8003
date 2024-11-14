package org.example.menus;

import org.example.utils.menu.Banner;
import org.example.utils.menu.Menu;

public class DecryptionMenus {
    public static Menu getDecryptionMenu() {
        Banner banner = Banner.create("");

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Méthode -CÉSAR-", () -> null)
                .addOption("2", "Méthode -VIGENÈRE-", () -> null)
                .addOption("3", "Méthode -CARRÉ DE POLYBE-", () -> PolybiusMenus.getPolybiusMenu(false))
                .addOption("", "Revenir au menu principal", null);
    }
}
