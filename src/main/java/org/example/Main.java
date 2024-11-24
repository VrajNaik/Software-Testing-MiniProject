package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        displayWelcomeMessage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 0) {
                    displayExitMessage();
                    break;
                }

                handleMenuChoice(choice);

            } catch (NumberFormatException e) {
                displayInvalidInputMessage();
            } catch (Exception e) {
                displayUnexpectedErrorMessage(e);
            }
        }
    }

    // Method to display the welcome message
    private static void displayWelcomeMessage() {
        System.out.println("============================================");
        System.out.println("      WELCOME TO THE FINANCIAL CALCULATOR   ");
        System.out.println("============================================");
        System.out.println("This tool provides a variety of calculators");
        System.out.println("to help you manage and plan your finances!");
        System.out.println("============================================");
    }

    // Method to display the menu
    private static void displayMenu() {
        System.out.println("\n=========== CALCULATOR MENU ===========");
        System.out.println(" 1. EMI Calculator - Plan your loan EMIs");
        System.out.println(" 2. Gratuity Calculator - Know your benefits");
        System.out.println(" 3. Lumpsum Calculator - Project your returns");
        System.out.println(" 4. PPF Calculator - Calculate PPF maturity");
        System.out.println(" 5. SIP Calculator - Systematic investment planning");
        System.out.println(" 6. SWP Calculator - Systematic withdrawal planning");
        System.out.println(" 0. Exit - Close the application");
        System.out.println("========================================");
    }

    // Method to handle the menu choice
    private static void handleMenuChoice(int choice) {
        System.out.println("\nYou selected option " + choice + ".");
        switch (choice) {
            case 1:
                System.out.println("\n---- EMI CALCULATOR ----");
                new EMICalculator().init();
                break;

            case 2:
                System.out.println("\n---- GRATUITY CALCULATOR ----");
                new GratuityCalculator().init();
                break;

            case 3:
                System.out.println("\n---- LUMPSUM CALCULATOR ----");
                new LumpsumCalculator().init();
                break;

            case 4:
                System.out.println("\n---- PPF CALCULATOR ----");
                new PPFCalculator().init();
                break;

            case 5:
                System.out.println("\n---- SIP CALCULATOR ----");
                new SIPCalculator().init();
                break;

            case 6:
                System.out.println("\n---- SWP CALCULATOR ----");
                new SWPCalculator().init();
                break;

            case 7:
                System.out.println("\n---- TAX CALCULATOR ----");
                new TaxCalculator().init();
                break;

            default:
                displayInvalidOptionMessage();
        }
    }

    // Method to display exit message
    private static void displayExitMessage() {
        System.out.println("\n============================================");
        System.out.println("       THANK YOU FOR USING OUR TOOL         ");
        System.out.println("  We hope this tool was helpful for you!    ");
        System.out.println("============================================");
        System.out.println("            HAVE A GREAT DAY!               ");
        System.out.println("============================================");
    }

    // Method to display invalid input message
    private static void displayInvalidInputMessage() {
        System.out.println("\nInvalid input! Please enter a number corresponding to an option in the menu.");
    }

    // Method to display invalid option message
    private static void displayInvalidOptionMessage() {
        System.out.println("\nInvalid option! Please select a valid choice from the menu.");
    }

    // Method to display unexpected error message
    private static void displayUnexpectedErrorMessage(Exception e) {
        System.out.println("\nAn unexpected error occurred. Please try again.");
        System.out.println("Error details: " + e.getMessage());
    }
}
