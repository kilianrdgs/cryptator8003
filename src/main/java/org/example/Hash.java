package org.example;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.example.saving.savingMethod;

public class Hash {
    static String pepper = "pepper";
    static String hashedString = "";

    public static void hash(String input, String type) throws NoSuchAlgorithmException, IOException {

        // Initialize a MessageDigest instance with the SHA-256 or MB5 algorithm
        MessageDigest md = MessageDigest.getInstance(type);

        // Update the MessageDigest with the bytes of the input text
        md.update(input.getBytes());

        // hash and obtain the byte array result
        byte[] digest = md.digest();

        // Create a StringBuffer to convert the byte array to a hex string
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff)); //format converting
        }

        // Generate a salt using the Aleatory.salt() method
        String salt = Aleatory.salt();
        System.out.println("hash : " + sb);
        System.out.println("salt : " + salt);

        if (type.equals("MD5")){
            hashedString = "salt MD5 : " + salt + '-' + sb + '-' + pepper;
        } else if (type.equals("SHA-256")){
            hashedString = "salt SHA-256 : " + salt + '-' + sb + '-' + pepper;
        }

        String filePath = System.getProperty("user.home") + "/Desktop/hashed_files/hashed_"+ type +"_messages.csv"; // Sets the file path
        savingMethod.saveEncryption(filePath, hashedString); // Saves the encrypted message

    }
}
