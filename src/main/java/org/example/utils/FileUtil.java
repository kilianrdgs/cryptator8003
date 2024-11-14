package org.example.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    public static boolean saveToFile(String filename, String content) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(content);
            System.out.println("Message sauvegardé avec succès !");
            return false;
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
            return true;
        }
    }
}
