package org.example.menus;

import org.example.utils.menu.Banner;
import org.example.utils.menu.Menu;

public class EncryptionMenus {
    public static Menu getEncryptionMenu() {
        Banner banner = Banner.create(
                "                   ____ _     _  __  __               ",
                "                  / ___| |__ (_)/ _|/ _|_ __ ___ _ __ ",
                "                 | |   | '_ \\| | |_| |_| '__/ _ \\ '__|",
                "                 | |___| | | | |  _|  _| | |  __/ |   ",
                "                  \\____|_| |_|_|_| |_| |_|  \\___|_|   "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Méthode -CÉSAR-", () -> null)
                .addOption("2", "Méthode -VIGENÈRE-", () -> null)
                .addOption("3", "Méthode -CARRÉ DE POLYBE-", () -> PolybiusMenus.getPolybiusMenu(true))
                .addOption("4", "Méthode -RC4-", () -> RC4Menus.getRC4Menu(true))
                .addOption("", "Retour", MainMenu::getMainMenu);
    }
}
