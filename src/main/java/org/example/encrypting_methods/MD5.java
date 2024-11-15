package org.example.encrypting_methods;

import org.example.Hash;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Class handling MD5 hashing operations
 */
public class MD5 {
    /**
     * Hashes a message using MD5 algorithm
     * @param message The message to hash
     * @throws NoSuchAlgorithmException If MD5 algorithm is not available
     * @throws IOException If there's an error saving the hash
     */
    public static void hash(String message) throws NoSuchAlgorithmException, IOException {
        Hash.hash(message, "MD5");
    }
}
