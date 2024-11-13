package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Aleatory {

    public static String salt() {
        // Get the current date and time, formate and convert to string
        LocalDateTime dateToday = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
        String dateTodayFormatted = dateToday.format(formatter);
        String grain = dateTodayFormatted.toString();

        int i;
        StringBuilder output = new StringBuilder();

        // Iterate over each character in the date-time string
        for (i = 0; i < grain.length(); i++) {
            // Convert each character to binary and apply binaryRoll, appending result to output
            output.append(binaryRoll("0" + Integer.toBinaryString(grain.charAt(i))));
        }

        // Return the final "salt" string generated
        return output.toString();
    }

    // Method to perform a bitwise "roll" on the binary representation of a character
    private static char binaryRoll(String caractereBinary){
        int i;
        String result = "";

        // repet the operation 8 times for 8 bytes
        for (i = 0; i <= 8; i++) {
            // positions 1 and 3 to compare
            String A = String.valueOf(caractereBinary.charAt(1));
            String B = String.valueOf(caractereBinary.charAt(3));

           // "XOR" :)
            if (Objects.equals(A, B)) {
                result = "0";
            } else {
                result = "1";
            }

            // Shift the binary string by removing the first character and adding the result at the end
            caractereBinary = caractereBinary.substring(1);
            caractereBinary = caractereBinary + result;
        }

        // Convert the final binary string back to a character
        return binaryToString(caractereBinary);
    }

    // Convert a binary string to its corresponding character
    private static char binaryToString(String sequenceBinary) {
        return (char) Integer.parseInt(sequenceBinary, 2);
    }
}
