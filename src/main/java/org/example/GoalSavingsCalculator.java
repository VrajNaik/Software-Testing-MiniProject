package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Advanced Goal Savings Calculator with exception handling and complex control flow.
 */
public class GoalSavingsCalculator {

    public void calculateGoalSavings() {
        Scanner scanner = new Scanner(System.in);
        double goalAmount = 0.0, initialSavings = 0.0, returnRate = 0.0;
        int years = 0;
        String frequency;

        System.out.println("\n=========== ADVANCED GOAL SAVINGS CALCULATOR ===========");

        // Input validation for goal and savings
        while (true) {
            try {
                System.out.print("Enter your financial goal amount (₹): ");
                goalAmount = scanner.nextDouble();

                System.out.print("Enter the time frame to achieve your goal (in years): ");
                years = scanner.nextInt();

                if (goalAmount <= 0 || years <= 0) {
                    throw new IllegalArgumentException("Goal amount and time frame must be positive.");
                }

                System.out.print("Enter the expected annual return rate (in %, e.g., 8 for 8%): ");
                returnRate = scanner.nextDouble();

                System.out.print("Enter any initial savings you already have (₹): ");
                initialSavings = scanner.nextDouble();

                if (returnRate <= 0 || initialSavings < 0) {
                    throw new IllegalArgumentException("Return rate must be positive, and savings cannot be negative.");
                }
                break; // Break loop if inputs are valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid numeric value.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Choose savings frequency
        while (true) {
            System.out.print("Do you prefer monthly or annual savings? (monthly/annual): ");
            frequency = scanner.next();

            if (frequency.equalsIgnoreCase("monthly") || frequency.equalsIgnoreCase("annual")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter either 'monthly' or 'annual'.");
            }
        }

        // Calculations
        try {
            double futureValueOfSavings = initialSavings * Math.pow(1 + returnRate / 100, years);
            double remainingGoal = goalAmount - futureValueOfSavings;

            if (remainingGoal <= 0) {
                System.out.println("Congratulations! Your current savings are sufficient to achieve your goal.");
            } else {
                int periods = frequency.equalsIgnoreCase("monthly") ? years * 12 : years;
                double periodicRate = returnRate / (frequency.equalsIgnoreCase("monthly") ? 12 : 1) / 100;
                double savingsPerPeriod = remainingGoal * periodicRate / (Math.pow(1 + periodicRate, periods) - 1);

                System.out.printf("\nTo achieve your goal of ₹%.2f, you need to save ₹%.2f %s.\n",
                        goalAmount, savingsPerPeriod, frequency.equalsIgnoreCase("monthly") ? "per month" : "per year");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during calculation: " + e.getMessage());
        }
    }
}
