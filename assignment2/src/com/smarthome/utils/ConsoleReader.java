package com.smarthome.utils;

import java.util.Scanner;

/**
 * A utility class to handle all console input operations.
 * This centralizes reading user input and basic validation.
 */
public class ConsoleReader {
    // A single scanner instance for the entire application
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Reads a line of text from the console.
     * @return The string entered by the user.
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer from the console.
     * Includes basic error handling for non-integer input.
     * @return The integer entered by the user.
     */
    public static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
