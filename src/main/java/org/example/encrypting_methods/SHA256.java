package org.example.encrypting_methods;

import org.example.Hash;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Class handling SHA-256 hashing operations
 */
public class SHA256 {
    /**
     * Hashes a message using SHA-256 algorithm
     * @param message The message to hash
     * @throws NoSuchAlgorithmException If SHA-256 algorithm is not available
     * @throws IOException If there's an error saving the hash
     */
    public static void hash(String message) throws NoSuchAlgorithmException, IOException {
        Hash.hash(message, "SHA-256");
    }
}
