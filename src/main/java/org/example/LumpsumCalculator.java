package org.example;

import java.util.Scanner;

public class LumpsumCalculator {

    private Double principleAmount; // Principal amount definition
    private Double interestRate;    // Interest rate definition
    private Double timePeriod;      // Time period definition

    public Double getPrincipleAmount() {
        return principleAmount; // Use: accessing principle amount
    }

    public void setPrincipleAmount(Double principleAmount) {
        this.principleAmount = principleAmount; // Definition: assigning principle amount
    }

    public Double getInterestRate() {
        return interestRate; // Use: accessing interest rate
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate; // Definition: assigning interest rate
    }

    public Double getTimePeriod() {
        return timePeriod; // Use: accessing time period
    }

    public void setTimePeriod(Double timePeriod) {
        this.timePeriod = timePeriod; // Definition: assigning time period
    }

    public LumpsumCalculator() {
        // Default constructor
    }

    public Long init() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt and validate principal amount
            setPrincipleAmount(promptForPositiveDouble(scanner, "Enter your total investment (Principal Amount): "));

            // Prompt and validate interest rate
            setInterestRate(promptForNonNegativeDouble(scanner, "Enter rate of interest (0-100): ", 0.0, 100.0));

            // Prompt and validate time period
            setTimePeriod(promptForPositiveDouble(scanner, "Enter the time period of investment (in years): "));

            // Use: Calculate and display total return
            Long totalReturn = calculateReturn();
            System.out.println("Your total gain will be: " + totalReturn);
            return totalReturn;
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

    private Double promptForNonNegativeDouble(Scanner scanner, String message, double min, double max) {
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

    private Long calculateReturn() {
        // Use: Compute total amount using compound interest formula
        Double totalAmount = principleAmount * Math.pow(1 + (interestRate / 100), timePeriod);
        return totalAmount.longValue(); // Return rounded total amount
    }
}
