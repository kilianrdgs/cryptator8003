package org.example;

import org.example.menus.HomeMenu;
import org.example.menus.MainMenu;
import org.example.utils.menu.Menu;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // HomeMenu.getHomeMenu();
        Menu currentMenu = MainMenu.getMainMenu();

        while (currentMenu != null) {
            currentMenu = currentMenu.run();
        }
    }
}