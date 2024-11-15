package org.example.menus;

import org.example.utils.menu.Banner;
import org.example.utils.menu.Menu;

public class DecryptionMenus {
    public static Menu getDecryptionMenu() {
        Banner banner = Banner.create(
                "                  ____                _     _  __  __                ",
                "                 |  _ \\  ___  ___| |__ (_)/ _|/ _|_ __ ___ _ __ ",
                "                 | | | |/ _ \\/ __| '_ \\| | |_| |_| '__/ _ \\ '__|",
                "                 | |_| |  __/ (__| | | | |  _|  _| | |  __/ |   ",
                "                 |____/ \\___|\\___|_| |_|_|_| |_| |_|  \\___|_|   "
        );

        return new Menu()
                .setBanner(banner)
                .addOption("1", "Méthode -CÉSAR-", () -> CaesarMenus.getCaesarMenu(false, false, null))
                .addOption("2", "Méthode -VIGENÈRE-", () -> VigenereMenus.getVigenereMenu(false, false, null))
                .addOption("3", "Méthode -CARRÉ DE POLYBE-", () -> PolybiusMenus.getPolybiusMenu(false, false, null))
                .addOption("4", "Méthode -RC4-", () -> RC4Menus.getRC4Menu(false, false, null))
                .addOption("5", "Méthode -ENIGMA-", () -> EnigmaMenus.getEnigmaMenu(false, false, null))
                .addOption("", "Retour", MainMenu::getMainMenu);
    }
}
