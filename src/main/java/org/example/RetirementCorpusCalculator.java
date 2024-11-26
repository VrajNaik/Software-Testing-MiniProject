package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Advanced Retirement Corpus Calculator with exception handling, nested conditions,
 * and modular structure for integration into a menu system.
 */
public class RetirementCorpusCalculator {

    /**
     * Entry point for the Retirement Corpus Calculator.
     */
    public void init() {
        calculateRetirementCorpus();
    }
    public double calculateCorpus(int currentAge, int retirementAge, int lifeExpectancy,
                                  double currentExpenses, double inflationRate, double returnRate) {
        if (currentAge >= retirementAge) {
            throw new IllegalArgumentException("Retirement age must be greater than current age.");
        }
        if (lifeExpectancy <= retirementAge) {
            throw new IllegalArgumentException("Life expectancy must be greater than retirement age.");
        }
        if (currentExpenses <= 0 || inflationRate < 0 || returnRate <= 0) {
            throw new IllegalArgumentException("All financial inputs must be positive values.");
        }

        int yearsUntilRetirement = retirementAge - currentAge;
        double futureExpenses = currentExpenses * Math.pow(1 + inflationRate / 100, yearsUntilRetirement);
        int retirementYears = lifeExpectancy - retirementAge;
        return (futureExpenses * 12) * ((1 - Math.pow(1 + returnRate / 100, -retirementYears)) / (returnRate / 100));
    }

    /**
     * Method to perform retirement corpus calculation with user inputs.
     */
    public void calculateRetirementCorpus() {
        Scanner scanner = new Scanner(System.in);
        int currentAge = 0, retirementAge = 0, lifeExpectancy = 0;
        double currentExpenses = 0.0, inflationRate = 0.0, returnRate = 0.0;

        System.out.println("\n=========== ADVANCED RETIREMENT CORPUS CALCULATOR ===========");

        // Input validation loop for age inputs
        while (true) {
                System.out.print("Enter your current age (years): ");
                currentAge = scanner.nextInt();

                System.out.print("Enter your desired retirement age (years): ");
                retirementAge = scanner.nextInt();

                if (currentAge >= retirementAge) {
                    System.out.println("Retirement age must be greater than current age.");
                    continue;
                }

                System.out.print("Enter your life expectancy (years): ");
                lifeExpectancy = scanner.nextInt();

                if (lifeExpectancy <= retirementAge) {
                    System.out.println("Life expectancy must be greater than retirement age.");
                    continue;
                }
                break; // Break loop if inputs are valid
        }

        // Input validation for financial parameters
        while (true) {
                System.out.print("Enter your current monthly expenses (₹): ");
                currentExpenses = scanner.nextDouble();

                System.out.print("Enter expected inflation rate (in %, e.g., 5 for 5%): ");
                inflationRate = scanner.nextDouble();

                System.out.print("Enter expected post-retirement return rate (in %, e.g., 6 for 6%): ");
                returnRate = scanner.nextDouble();

                if (currentExpenses <= 0 || inflationRate < 0 || returnRate <= 0) {
                    System.out.println("All financial inputs must be positive values.");
                    continue;
                }
                break; // Break loop if inputs are valid
        }

        // Core calculations
            int yearsUntilRetirement = retirementAge - currentAge;
            double futureExpenses = currentExpenses * Math.pow(1 + inflationRate / 100, yearsUntilRetirement);
            int retirementYears = lifeExpectancy - retirementAge;
            double corpus = (futureExpenses * 12) * ((1 - Math.pow(1 + returnRate / 100, -retirementYears)) / (returnRate / 100));

            System.out.printf("\nYour estimated retirement corpus: ₹%.2f\n", corpus);
            System.out.printf("This corpus will support expenses of ₹%.2f per month post-retirement.\n", futureExpenses);
    }
}


//try {
//        System.out.print("Enter your current age (years): ");
//currentAge = scanner.nextInt();
//
//                System.out.print("Enter your desired retirement age (years): ");
//retirementAge = scanner.nextInt();
//
//                if (currentAge >= retirementAge) {
//        System.out.println("Retirement age must be greater than current age.");
//                    continue;
//                            }
//
//                            System.out.print("Enter your life expectancy (years): ");
//lifeExpectancy = scanner.nextInt();
//
//                if (lifeExpectancy <= retirementAge) {
//        System.out.println("Life expectancy must be greater than retirement age.");
//                    continue;
//                            }
//                            break; // Break loop if inputs are valid
//                            } catch (InputMismatchException e) {
//        System.out.println("Invalid input! Please enter a valid integer value.");
//                scanner.next(); // Clear invalid input
//            } catch (IllegalArgumentException e) {
//        System.out.println("Error: " + e.getMessage());
//        }

//while (true) {
//        try {
//        System.out.print("Enter your current monthly expenses (₹): ");
//currentExpenses = scanner.nextDouble();
//
//                System.out.print("Enter expected inflation rate (in %, e.g., 5 for 5%): ");
//inflationRate = scanner.nextDouble();
//
//                System.out.print("Enter expected post-retirement return rate (in %, e.g., 6 for 6%): ");
//returnRate = scanner.nextDouble();
//
//                if (currentExpenses <= 0 || inflationRate < 0 || returnRate <= 0) {
//        System.out.println("All financial inputs must be positive values.");
//                    continue;
//                            }
//                            break; // Break loop if inputs are valid
//                            } catch (InputMismatchException e) {
//        System.out.println("Invalid input! Please enter a valid numeric value.");
//                scanner.next(); // Clear invalid input
//            } catch (IllegalArgumentException e) {
//        System.out.println("Error: " + e.getMessage());
//        }


//        try {
//int yearsUntilRetirement = retirementAge - currentAge;
//double futureExpenses = currentExpenses * Math.pow(1 + inflationRate / 100, yearsUntilRetirement);
//int retirementYears = lifeExpectancy - retirementAge;
//double corpus = (futureExpenses * 12) * ((1 - Math.pow(1 + returnRate / 100, -retirementYears)) / (returnRate / 100));
//
//            System.out.printf("\nYour estimated retirement corpus: ₹%.2f\n", corpus);
//            System.out.printf("This corpus will support expenses of ₹%.2f per month post-retirement.\n", futureExpenses);
//        } catch (Exception e) {
//        System.out.println("An unexpected error occurred during calculation: " + e.getMessage());
//        }