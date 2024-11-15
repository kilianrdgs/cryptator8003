package org.example.hashing_methods;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Class handling SHA-256 hashing operations
 */
public class SHA256 {
    /**
     * Hashes a message using SHA-256 algorithm
     * @param message The message to hash
     * @return The hashed message with salt and pepper
     * @throws NoSuchAlgorithmException If SHA-256 algorithm is not available
     * @throws IOException If there's an error during hashing
     */
    public static String hash(String message) throws NoSuchAlgorithmException, IOException {
        return Hash.hash(message, "SHA-256");
    }
}
