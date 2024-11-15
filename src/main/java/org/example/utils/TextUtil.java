package org.example.utils;

import java.text.Normalizer;

/**
 * Utility class for text manipulation operations
 */
public class TextUtil {
    /**
     * Removes accents from a character and converts it to its base form
     * e.g., 'é' -> 'e', 'à' -> 'a', etc.
     * 
     * @param c The character to process
     * @return The character without accents
     */
    public static char removeAccents(char c) {
        String normalized = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD);
        normalized = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return normalized.charAt(0);
    }
}
