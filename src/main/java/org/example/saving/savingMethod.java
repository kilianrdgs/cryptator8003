package org.example.saving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class savingMethod {
    public static void saveEncryption(String filePath, String data) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
        try {
            pw.println(data);
        }
        finally {
            pw.close();
        }
    }
}
