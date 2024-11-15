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
                .addOption("1", "Méthode -CÉSAR-", () -> CaesarMenus.getCaesarMenu(true, false, null))
                .addOption("2", "Méthode -VIGENÈRE-", () -> VigenereMenus.getVigenereMenu(true, false, null))
                .addOption("3", "Méthode -CARRÉ DE POLYBE-", () -> PolybiusMenus.getPolybiusMenu(true, false, null))
                .addOption("4", "Méthode -RC4-", () -> RC4Menus.getRC4Menu(true, false, null))
                .addOption("5", "Méthode -ENIGMA-", () -> EnigmaMenus.getEnigmaMenu(true, false, null))
                .addOption("", "Retour", MainMenu::getMainMenu);
    }
}
