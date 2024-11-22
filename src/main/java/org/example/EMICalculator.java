package org.example;

import java.util.Scanner;

public class EMICalculator {
    private Double loanAmount;   // Loan amount definition
    private Double interestRate; // Interest rate definition
    private Double loanTenure;   // Loan tenure definition

    public Double getLoanAmount() {
        return loanAmount; // Use: accessing loan amount
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount; // Definition: assigning loan amount
    }

    public Double getInterestRate() {
        return interestRate; // Use: accessing interest rate
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate; // Definition: assigning interest rate
    }

    public Double getLoanTenure() {
        return loanTenure; // Use: accessing loan tenure
    }

    public void setLoanTenure(Double loanTenure) {
        this.loanTenure = loanTenure; // Definition: assigning loan tenure
    }

    public Long init() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt and validate loan amount
            setLoanAmount(promptForPositiveDouble(scanner, "Enter your loan amount: "));

            // Prompt and validate interest rate
            setInterestRate(promptForDoubleInRange(scanner, "Enter rate of interest (0-100%): ", 0.0, 100.0));

            // Prompt and validate loan tenure
            setLoanTenure(promptForPositiveDouble(scanner, "Enter loan tenure in years: "));

            // Use: Calculate EMI
            Long totalEMI = calculateEMI();
            System.out.println("Your EMI is: " + totalEMI);
            return totalEMI;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return -1L; // Return error indicator
        }
    }

    private Double promptForPositiveDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                Double input = Double.parseDouble(scanner.nextLine().trim());
                if (input > 0) {
                    return input; // Valid positive input
                } else {
                    System.out.println("Please enter a positive value.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private Double promptForDoubleInRange(Scanner scanner, String message, double min, double max) {
        while (true) {
            System.out.print(message);
            try {
                Double input = Double.parseDouble(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    return input; // Valid range input
                } else {
                    System.out.println("Please enter a value between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    public Long calculateEMI() {
        // Use: Loan amount, interest rate, and tenure in EMI formula
        double monthlyInterestRate = getInterestRate() / 1200; // Monthly interest rate
        double months = getLoanTenure() * 12; // Total months
        double emi = (getLoanAmount() * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) /
                (Math.pow(1 + monthlyInterestRate, months) - 1);
        return (long) emi; // Return rounded EMI value
    }
}
