package org.example.hashing_methods;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.example.Aleatory;

/**
 * Class handling hashing operations with salt and pepper
 */
public class Hash {
    private static final String pepper = "pepper";

    /**
     * Hashes a message using the specified algorithm
     * @param input The message to hash
     * @param type The hashing algorithm (MD5 or SHA-256)
     * @return The hashed message with salt and pepper
     * @throws NoSuchAlgorithmException If the algorithm is not available
     * @throws IOException If there's an error during hashing
     */
    public static String hash(String input, String type) throws NoSuchAlgorithmException, IOException {
        // Initialize a MessageDigest instance with the SHA-256 or MD5 algorithm
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
            return "salt MD5 : " + salt + '-' + sb + '-' + pepper;
        } else {
            return "salt SHA-256 : " + salt + '-' + sb + '-' + pepper;
        }
    }
}
