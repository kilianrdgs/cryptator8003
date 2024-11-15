package org.example.hashing_methods;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Class handling MD5 hashing operations
 */
public class MD5 {
    /**
     * Hashes a message using MD5 algorithm
     * @param message The message to hash
     * @return The hashed message with salt and pepper
     * @throws NoSuchAlgorithmException If MD5 algorithm is not available
     * @throws IOException If there's an error during hashing
     */
    public static String hash(String message) throws NoSuchAlgorithmException, IOException {
        return Hash.hash(message, "MD5");
    }
}
