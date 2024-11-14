package org.example;

import org.example.menus.homeMenu;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
     //homeMenu.getHomeMenu();
       Hash.hash("hello", "SHA-256");
    }
}