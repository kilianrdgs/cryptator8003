package org.example.encrypting_methods;

/**
 * Implementation of the RC4 (Rivest Cipher 4) stream cipher algorithm.
 * RC4 is a symmetric key algorithm that generates a pseudorandom stream of bits (keystream)
 * which is combined with the plaintext using bitwise XOR for encryption/decryption.
 * Note: While historically significant, RC4 is now considered cryptographically weak
 * and should not be used for secure communications.
 */
public class RC4 {

    /**
     * Generates the initial state array (S-box) through the Key Scheduling Algorithm (KSA).
     * The KSA initializes a permutation array using the provided encryption key.
     * 
     * Algorithm overview:
     * 1. Initialize array S with sequential values 0-255
     * 2. Perform key-based shuffling of array S
     * 3. Result is a permuted S-box based on the key
     * 
     * @param key The encryption/decryption key as a byte array
     * @return An integer array containing the initialized S-box permutation
     */
    private static int[] generateKeySchedule(byte[] key) {
        // Initialize S-box with sequential values
        int[] keySchedule = new int[256];
        for (int num = 0; num < 256; num++) {
            keySchedule[num] = num;
        }

        // Key Scheduling Algorithm (KSA)
        // Performs initial permutation of the S-box based on the key
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + keySchedule[i] + (key[i % key.length] & 0xFF)) % 256;
            
            // Swap values at indices i and j
            int temp = keySchedule[i];
            keySchedule[i] = keySchedule[j];
            keySchedule[j] = temp;
        }

        return keySchedule;
    }

    /**
     * Performs RC4 encryption/decryption using the Pseudo-Random Generation Algorithm (PRGA).
     * The PRGA generates the keystream which is XORed with the input data.
     * 
     * Process overview:
     * 1. Initialize state using the key (KSA)
     * 2. Generate keystream bytes using PRGA
     * 3. Combine keystream with input data using XOR
     * 
     * @param data The input data to be encrypted/decrypted
     * @param key The encryption/decryption key
     * @return The processed data (encrypted if input was plaintext, decrypted if input was ciphertext)
     */
    private static byte[] process(byte[] data, byte[] key) {
        // Initialize state array using KSA
        int[] keySchedule = generateKeySchedule(key);
        byte[] processedData = new byte[data.length];

        // Pseudo-Random Generation Algorithm (PRGA)
        // Generates keystream and combines it with input data
        int i = 0, j = 0;
        
        for (int k = 0; k < data.length; k++) {
            i = (i + 1) % 256;
            j = (j + keySchedule[i]) % 256;
            
            // Swap values
            int temp = keySchedule[i];
            keySchedule[i] = keySchedule[j];
            keySchedule[j] = temp;
            
            // Generate keystream byte and XOR with data
            int keystreamByte = keySchedule[(keySchedule[i] + keySchedule[j]) % 256];
            processedData[k] = (byte) (data[k] ^ keystreamByte);
        }

        return processedData;
    }

    /**
     * Encrypts the given data using the provided key.
     *
     * @param data The data to be encrypted
     * @param key The encryption key
     * @return The encrypted data
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        return process(data, key);
    }

    /**
     * Decrypts the given data using the provided key.
     *
     * @param data The data to be decrypted
     * @param key The decryption key
     * @return The decrypted data
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        return process(data, key);
    }
}