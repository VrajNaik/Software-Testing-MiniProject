package org.example;

import java.util.Scanner;

public class GratuityCalculator {
    private Double monthlySalary; // Variable definition (monthly salary)
    private Double yearsOfService; // Variable definition (years of service)

    public Double getMonthlySalary() {
        return monthlySalary; // Use: accessing monthly salary
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary; // Definition: assigning monthly salary
    }

    public Double getYearsOfService() {
        return yearsOfService; // Use: accessing years of service
    }

    public void setYearsOfService(Double yearsOfService) {
        this.yearsOfService = yearsOfService; // Definition: assigning years of service
    }

    public Long init() {
        Double ms; // Definition: temporary variable for monthly salary
        Double yos; // Definition: temporary variable for years of service

        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt and validate monthly salary
            while (true) {
                System.out.print("Enter your monthly salary amount: ");
                try {
                    ms = Double.parseDouble(scanner.nextLine().trim());
                    if (ms >= 0) {
                        break; // Valid input
                    }
                    System.out.println("Please enter a positive monthly salary.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                }
            }
            setMonthlySalary(ms); // Definition: assigning validated monthly salary to class field

            // Prompt and validate years of service
            while (true) {
                System.out.print("Enter your years of service: ");
                try {
                    yos = Double.parseDouble(scanner.nextLine().trim());
                    if (yos >= 0) {
                        break; // Valid input
                    }
                    System.out.println("Please enter a valid positive number for years of service.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                }
            }
            setYearsOfService(yos); // Definition: assigning validated years of service to class field

            // Use: calculate the gratuity amount
            Long totalValue = calculateReturn();
            System.out.println("You are eligible for " + totalValue + " gratuity.");
            return totalValue; // Return calculated gratuity value
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return -1L; // Return error indicator
        }
    }

    public Long calculateReturn() {
        // Use: reading monthly salary and years of service for calculation
        Double gratuity = getYearsOfService() * getMonthlySalary() * 15 / 26;
        return Math.min(1_000_000L, gratuity.longValue()); // Cap at 1,000,000
    }
}
