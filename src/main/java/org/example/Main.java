package org.example;

import org.example.menus.HomeMenu;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
      HomeMenu.getHomeMenu();
      //Hash.hash("hello", "SHA-256");
    }
}