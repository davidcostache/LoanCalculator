package io.davidalexandru.loancalculator;

import java.util.Scanner;

public class Input {

    /**
     * Reads a numerical input from the user within the specified range.
     *
     * @param scanner The Scanner object for input.
     * @param prompt  The message prompting the user for input.
     * @param min     The minimum allowed value.
     * @param max     The maximum allowed value.
     * @return The valid user input value.
     */
    public static double readNumber(Scanner scanner, String prompt, int min, int max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Please enter a number between " + min + " and " + max);
        }
        return value;
    }
}
