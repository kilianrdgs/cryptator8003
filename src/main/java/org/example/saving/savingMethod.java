package org.example.saving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class savingMethod {
    public static void saveEncryption(String filePath, String data) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
        try {
            pw.println(data);
        } finally {
            pw.close();
        }
    }
}
