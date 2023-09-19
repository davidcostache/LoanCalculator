package io.davidalexandru.loancalculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read user input for loan details
        int principal = (int) Input.readNumber(scanner, "Enter the loan amount (Principal): $", 1_000, 1_000_000);
        double annualInterest = Input.readNumber(scanner, "Enter the annual interest rate (%): ", 1, 30);
        int numberOfPayments = (int) Input.readNumber(scanner, "Enter the loan duration (Years): ", 1, 30);

        // Create instances of LoanSchedule and LoanReport
        var calculator = new Schedule(principal, annualInterest, numberOfPayments);
        var report = new Report(calculator);

        // Calculate and display monthly payment
        report.calculateAndDisplayMonthlyPayment();

        // Display payment schedule
        report.displayPaymentSchedule();

        scanner.close();
    }
}