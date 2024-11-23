package org.example;

import java.util.Scanner;

public class SIPCalculator {
    private Double monthlyInvestment;                   // Monthly investment amount
    private Double expectedReturnRateInPercentage;      // Annual return rate (percentage)
    private Double timePeriodInYear;                    // Investment period in years

    // Getter and Setter for Monthly Investment
    public Double getMonthlyInvestment() {
        return monthlyInvestment;                      // Access monthly investment value
    }

    public void setMonthlyInvestment(Double monthlyInvestment) {
        this.monthlyInvestment = monthlyInvestment;    // Assign monthly investment value
    }

    // Getter and Setter for Expected Return Rate
    public Double getExpectedReturnRateInPercentage() {
        return expectedReturnRateInPercentage;         // Access annual return rate
    }

    public void setExpectedReturnRateInPercentage(Double expectedReturnRateInPercentage) {
        this.expectedReturnRateInPercentage = expectedReturnRateInPercentage; // Assign annual return rate
    }

    // Getter and Setter for Time Period
    public Double getTimePeriodInYear() {
        return timePeriodInYear;                       // Access investment period
    }

    public void setTimePeriodInYear(Double timePeriodInYear) {
        this.timePeriodInYear = timePeriodInYear;      // Assign investment period
    }

    // Constructor
    public SIPCalculator() {
    }

    // Entry Point for Initialization
    public Long init() {
        try {
            Scanner scanner = new Scanner(System.in);

            // Collect and Validate Monthly Investment
            Double monthlyInvestmentValue = collectPositiveInput(scanner, "Enter your monthly investment amount: ");
            Double validatedMonthlyInvestment = validateInvestment(monthlyInvestmentValue);
            setMonthlyInvestment(validatedMonthlyInvestment);

            // Collect and Validate Expected Return Rate
            Double returnRateInput = collectPositiveInput(scanner, "Enter Expected Return Rate in percentage (per annum): ");
            Double validatedReturnRate = validateReturnRate(returnRateInput);
            Double monthlyReturnRate = calculateMonthlyReturnRate(validatedReturnRate);
            setExpectedReturnRateInPercentage(monthlyReturnRate);

            // Collect and Validate Time Period
            Double timePeriodInput = collectPositiveInput(scanner, "Enter time period for which you want to invest (in years): ");
            Double validatedTimePeriod = validateTimePeriod(timePeriodInput);
            setTimePeriodInYear(validatedTimePeriod);

            // Perform Final Calculation
            Long totalValue = calculateReturn();
            displayResult(totalValue);

            return totalValue;
        } catch (Exception e) {
            handleError(e);
            return -1L;
        }
    }

    // Method to Collect Positive Input
    private Double collectPositiveInput(Scanner scanner, String promptMessage) {
        System.out.print(promptMessage);
        String input = scanner.nextLine();
        return parseDoubleInput(input);
    }

    // Parse Double Input
    private Double parseDoubleInput(String input) {
        return Double.parseDouble(input.trim()); // Trim and convert input to Double
    }

    // Validate Investment Amount
    private Double validateInvestment(Double investment) {
        if (investment <= 0) {
            return defaultInvestment();
        }
        return investment;
    }

    // Validate Return Rate
    private Double validateReturnRate(Double rate) {
        if (rate < 0) {
            return defaultReturnRate();
        }
        return rate;
    }

    // Validate Time Period
    private Double validateTimePeriod(Double period) {
        if (period <= 0) {
            return defaultTimePeriod();
        }
        return period;
    }

    // Default Values
    private Double defaultInvestment() {
        return 1000.0; // Default minimum investment
    }

    private Double defaultReturnRate() {
        return 6.0; // Default annual return rate
    }

    private Double defaultTimePeriod() {
        return 1.0; // Default time period in years
    }

    // Calculate Monthly Return Rate
    private Double calculateMonthlyReturnRate(Double annualRate) {
        return annualRate / 12; // Convert annual rate to monthly rate
    }

    // Display Final Result
    private void displayResult(Long totalValue) {
        System.out.println("Your total value will be: " + totalValue);
    }

    // Handle Errors
    private void handleError(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }

    // Final Return Calculation
    public Long calculateReturn() {
        // Retrieve Inputs
        Double monthlyInvestmentValue = getMonthlyInvestment();
        Double monthlyRate = getExpectedReturnRateInPercentage();
        Double timePeriodMonths = getTimePeriodInYear() * 12;

        // Intermediate Calculations
        Double rateFactor = 1 + (monthlyRate / 100);
        Double compoundFactor = Math.pow(rateFactor, timePeriodMonths);
        Double numerator = compoundFactor - 1;
        Double denominator = monthlyRate / 100;

        // Final Calculation
        Double totalAmount = monthlyInvestmentValue * (numerator / denominator) * rateFactor;
        Double roundedAmount = Math.floor(totalAmount); // Explicit rounding
        return roundedAmount.longValue();
    }
}
