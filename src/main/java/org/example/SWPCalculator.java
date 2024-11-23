package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SWPCalculator {

    private Double totalInvestment;   // Total investment amount
    private Double withdrawalAmount; // Monthly withdrawal amount
    private Double expectedReturnRate; // Annual return rate in percentage
    private Double timePeriod;       // Investment duration in years

    // Constructor
    public SWPCalculator() {
    }

    // Getters and Setters
    public Double getTotalInvestment() {
        return totalInvestment; // Returns the total investment
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment; // Sets the total investment
    }

    public Double getWithdrawalAmount() {
        return withdrawalAmount; // Returns the withdrawal amount
    }

    public void setWithdrawalAmount(Double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount; // Sets the withdrawal amount
    }

    public Double getExpectedReturnRate() {
        return expectedReturnRate; // Returns the expected return rate
    }

    public void setExpectedReturnRate(Double expectedReturnRate) {
        this.expectedReturnRate = expectedReturnRate; // Sets the expected return rate
    }

    public Double getTimePeriod() {
        return timePeriod; // Returns the investment period
    }

    public void setTimePeriod(Double timePeriod) {
        this.timePeriod = timePeriod; // Sets the investment period
    }

    // Initialization Method
    public Long init() {
        try {
            Scanner scanner = new Scanner(System.in);

            // Collect Total Investment Amount
            Double investmentInput = collectPositiveInput(scanner, "Enter total amount of investment: ");
            setTotalInvestment(investmentInput);

            // Collect Withdrawal Amount
            Double withdrawalInput = collectPositiveInput(scanner, "Enter amount of withdrawal per month: ");
            setWithdrawalAmount(withdrawalInput);

            // Collect Expected Return Rate
            Double returnRateInput = collectExpectedReturnRate(scanner, "Enter expected annual return rate (percentage): ");
            setExpectedReturnRate(returnRateInput);

            // Collect Time Period
            Double timePeriodInput = collectPositiveInput(scanner, "Enter time period in years: ");
            setTimePeriod(timePeriodInput);

            // Perform Calculation
            Double interestGained = calculateReturn();
            displayResult(interestGained);

            return Math.round(interestGained);
        } catch (Exception exception) {
            handleException(exception);
            return -1L;
        }
    }

    // Method to Collect Positive Input
    private Double collectPositiveInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                Double value = scanner.nextDouble();
                if (value >= 0) {
                    return value;
                }
                System.out.println("Please enter a non-negative value.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    // Method to Collect Expected Return Rate
    private Double collectExpectedReturnRate(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextDouble(); // Assumes non-negative rate provided
    }

    // Method to Display Result
    private void displayResult(Double interestGained) {
        System.out.println("Your interest gain will be: " + Math.round(interestGained));
    }

    // Error Handling
    private void handleException(Exception exception) {
        System.out.println("An error occurred during calculation: " + exception.getMessage());
    }

    // Core Calculation Method
    private Double calculateReturn() {
        Double remainingInvestment = getTotalInvestment(); // Initial investment amount
        Double monthlyWithdrawal = getWithdrawalAmount();  // Monthly withdrawal amount
        Double monthlyRate = getExpectedReturnRate() / 12; // Monthly interest rate
        int totalMonths = (int) (getTimePeriod() * 12);    // Convert years to months
        Double totalGain = 0.0;                           // Cumulative interest earned

        // Simulate each month
        for (int month = 0; month < totalMonths && remainingInvestment > 0; month++) {
            remainingInvestment -= monthlyWithdrawal; // Deduct withdrawal amount
            if (remainingInvestment <= 0) {
                break; // Break if funds are exhausted
            }
            Double interestEarned = remainingInvestment * (monthlyRate / 100); // Monthly interest
            totalGain += interestEarned; // Add interest to total gain
            remainingInvestment += interestEarned; // Update remaining investment
        }

        return totalGain; // Total interest gained
    }
}
