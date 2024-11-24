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
                    break; // Exits the loop when choice is 0
                }

                handleMenuChoice(choice);

            } catch (NumberFormatException e) {
                displayInvalidInputMessage();
            } catch (Exception e) {
                displayUnexpectedErrorMessage(e);
            }
        }

        scanner.close(); // Close the scanner when done
    }

    // Enhanced welcome message with ASCII art and color
    private static void displayWelcomeMessage() {
        System.out.println("\033[1;33m============================================\033[0m");
        System.out.println("\033[1;34m       WELCOME TO THE FINANCIAL CALCULATOR   \033[0m");
        System.out.println("\033[1;33m============================================\033[0m");
        System.out.println("\n\033[1;32m*** Helping You Plan Your Financial Future ***\033[0m");
        System.out.println("\nThis tool provides a variety of calculators");
        System.out.println("to help you manage and plan your finances!");
        System.out.println("============================================");
    }

    // Enhanced menu with advanced graphics and ANSI colors
    private static void displayMenu() {
        System.out.println("\n\033[1;36m╔══════════════════════════════════════════════╗\033[0m");
        System.out.println("║                    \033[1;35mCALCULATOR MENU\033[0m                    ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.println("\033[1;32m-------------------------------------------------\033[0m");
        System.out.println("1. EMI Calculator          - Plan your loan EMIs");
        System.out.println("2. Gratuity Calculator     - Know your benefits");
        System.out.println("3. Lumpsum Calculator      - Project your returns");
        System.out.println("4. PPF Calculator          - Calculate PPF maturity");
        System.out.println("5. SIP Calculator          - Systematic investment planning");
        System.out.println("6. SWP Calculator          - Systematic withdrawal planning");
        System.out.println("7. Income Tax Calculator   - Tax planning made easy");
        System.out.println("8. Retirement Corpus       - Plan your retirement fund");
        System.out.println("9. Goal Savings Calculator - Achieve your financial goals");
        System.out.println("10. Budget Planning        - Plan and allocate your budget");
        System.out.println("\033[1;31m0. Exit                    - Exit the application\033[0m");
        System.out.println("\033[1;32m-------------------------------------------------\033[0m");
    }

    // Handle menu choice selection
    private static void handleMenuChoice(int choice) {
        System.out.println("\n\033[1;36mYou selected option " + choice + ".\033[0m");
        switch (choice) {
            case 1:
                System.out.println("\n\033[1;34m---- EMI CALCULATOR ----\033[0m");
                new EMICalculator().init();
                break;

            case 2:
                System.out.println("\n\033[1;34m---- GRATUITY CALCULATOR ----\033[0m");
                new GratuityCalculator().init();
                break;

            case 3:
                System.out.println("\n\033[1;34m---- LUMPSUM CALCULATOR ----\033[0m");
                new LumpsumCalculator().init();
                break;

            case 4:
                System.out.println("\n\033[1;34m---- PPF CALCULATOR ----\033[0m");
                new PPFCalculator().init();
                break;

            case 5:
                System.out.println("\n\033[1;34m---- SIP CALCULATOR ----\033[0m");
                new SIPCalculator().init();
                break;

            case 6:
                System.out.println("\n\033[1;34m---- SWP CALCULATOR ----\033[0m");
                new SWPCalculator().init();
                break;

            case 7:
                System.out.println("\n\033[1;34m---- TAX CALCULATOR ----\033[0m");
                new TaxCalculator().init();
                break;

            case 8:
                System.out.println("\n\033[1;34m---- RETIREMENT CORPUS CALCULATOR ----\033[0m");
                new RetirementCorpusCalculator().init();
                break;

            case 9:
                System.out.println("\n\033[1;34m---- GOAL SAVINGS CALCULATOR ----\033[0m");
                new GoalSavingsCalculator().init();
                break;

            case 10:
                System.out.println("\n\033[1;34m---- BUDGET PLANNING CALCULATOR ----\033[0m");
                new BudgetPlanningCalculator().init();
                break;

            default:
                displayInvalidOptionMessage();
        }
    }

    // Display exit message with a touch of style
    private static void displayExitMessage() {
        System.out.println("\n\033[1;33m============================================\033[0m");
        System.out.println("\033[1;32m       THANK YOU FOR USING OUR TOOL         \033[0m");
        System.out.println("\033[1;33m  We hope this tool was helpful for you!    \033[0m");
        System.out.println("\033[1;33m============================================\033[0m");
        System.out.println("           \033[1;35mHAVE A GREAT DAY!\033[0m               ");
        System.out.println("\033[1;33m============================================\033[0m");
    }

    // Invalid input message
    private static void displayInvalidInputMessage() {
        System.out.println("\n\033[1;31mInvalid input! Please enter a number corresponding to an option in the menu.\033[0m");
    }

    // Invalid option message
    private static void displayInvalidOptionMessage() {
        System.out.println("\n\033[1;31mInvalid option! Please select a valid choice from the menu.\033[0m");
    }

    // Unexpected error message
    private static void displayUnexpectedErrorMessage(Exception e) {
        System.out.println("\n\033[1;31mAn unexpected error occurred. Please try again.\033[0m");
        System.out.println("Error details: " + e.getMessage());
    }
}
