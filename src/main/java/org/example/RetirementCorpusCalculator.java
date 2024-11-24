package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Advanced Retirement Corpus Calculator with exception handling and complex control flow.
 */
public class RetirementCorpusCalculator {

    public void calculateRetirementCorpus() {
        Scanner scanner = new Scanner(System.in);
        int currentAge = 0, retirementAge = 0, lifeExpectancy = 0;
        double currentExpenses = 0.0, inflationRate = 0.0, returnRate = 0.0;

        System.out.println("\n=========== ADVANCED RETIREMENT CORPUS CALCULATOR ===========");

        // Input validation loop for age inputs
        while (true) {
            try {
                System.out.print("Enter your current age (years): ");
                currentAge = scanner.nextInt();

                System.out.print("Enter your desired retirement age (years): ");
                retirementAge = scanner.nextInt();

                if (currentAge >= retirementAge) {
                    throw new IllegalArgumentException("Retirement age must be greater than current age.");
                }

                System.out.print("Enter your life expectancy (years): ");
                lifeExpectancy = scanner.nextInt();

                if (lifeExpectancy <= retirementAge) {
                    throw new IllegalArgumentException("Life expectancy must be greater than retirement age.");
                }
                break; // Break loop if inputs are valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer value.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Input validation for financial parameters
        while (true) {
            try {
                System.out.print("Enter your current monthly expenses (₹): ");
                currentExpenses = scanner.nextDouble();

                System.out.print("Enter expected inflation rate (in %, e.g., 5 for 5%): ");
                inflationRate = scanner.nextDouble();

                System.out.print("Enter expected post-retirement return rate (in %, e.g., 6 for 6%): ");
                returnRate = scanner.nextDouble();

                if (currentExpenses <= 0 || inflationRate < 0 || returnRate <= 0) {
                    throw new IllegalArgumentException("All financial inputs must be positive values.");
                }
                break; // Break loop if inputs are valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid numeric value.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Core calculations
        try {
            int yearsUntilRetirement = retirementAge - currentAge;
            double futureExpenses = currentExpenses * Math.pow(1 + inflationRate / 100, yearsUntilRetirement);
            int retirementYears = lifeExpectancy - retirementAge;
            double corpus = (futureExpenses * 12) * ((1 - Math.pow(1 + returnRate / 100, -retirementYears)) / (returnRate / 100));

            System.out.printf("\nYour estimated retirement corpus: ₹%.2f\n", corpus);
            System.out.printf("This corpus will support expenses of ₹%.2f per month post-retirement.\n", futureExpenses);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during calculation: " + e.getMessage());
        }
    }
}
