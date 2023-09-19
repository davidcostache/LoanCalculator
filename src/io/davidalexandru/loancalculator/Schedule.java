package io.davidalexandru.loancalculator;

public class Schedule {

    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENT = 100;
    private final int principal;
    private final double annualInterest;
    private final int years;

    /**
     * Constructs a Schedule with loan details.
     *
     * @param principal      The loan amount.
     * @param annualInterest The annual interest rate.
     * @param years          The loan duration in years.
     */
    public Schedule(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    /**
     * Calculates the monthly mortgage payment.
     *
     * @return The monthly mortgage payment.
     */
    public double calculateMortgage() {
        double monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    /**
     * Calculates the remaining balance on the loan after a given number of payments.
     *
     * @param numberOfPaymentsMade The number of payments made.
     * @return The remaining balance on the loan.
     */
    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    /**
     * Retrieves an array of remaining balances for each month.
     *
     * @return An array of remaining balances.
     */
    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private double getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}