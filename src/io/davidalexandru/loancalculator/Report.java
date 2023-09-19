package io.davidalexandru.loancalculator;

import java.text.NumberFormat;

public class Report {

    private final Schedule schedule;

    /**
     * Constructs a Report for a given LoanSchedule.
     *
     * @param calculator The Schedule instance used for calculations.
     */
    public Report(Schedule calculator) {
        this.schedule = calculator;
    }

    /**
     * Calculates and displays the monthly mortgage payment.
     */
    public void calculateAndDisplayMonthlyPayment() {
        double monthlyPayment = schedule.calculateMortgage();
        printMessage("Monthly Payment: " + formatAsCurrency(monthlyPayment));
    }

    /**
     * Displays the payment schedule, including the remaining balance for each month.
     */
    public void displayPaymentSchedule() {
        printMessage("PAYMENT SCHEDULE");

        double[] remainingBalances = schedule.getRemainingBalances();
        for (int month = 1; month <= remainingBalances.length; month++) {
            printMessage("Month " + month + ": " + formatAsCurrency(remainingBalances[month - 1]));
        }
    }

    /**
     * Formats a numeric value as currency.
     *
     * @param value The numeric value to format.
     * @return The value formatted as currency.
     */
    private String formatAsCurrency(double value) {
        return NumberFormat.getCurrencyInstance().format(value);
    }

    /**
     * Displays a message to the console.
     *
     * @param message The message to display.
     */
    private void printMessage(String message) {
        System.out.println(message);
    }
}