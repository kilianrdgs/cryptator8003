package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    static String pepper = "pepper";

    public static void hash(String input, String type) throws NoSuchAlgorithmException {

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
            System.out.println("salt MD5 : " + salt + '-' + sb + '-' + pepper);
        } else if (type.equals("SHA-256")){
            System.out.println("salt SHA-256 : " + salt + '-' + sb + '-' + pepper);
        }

    }
}
