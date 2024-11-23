package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Welcome to the Calculator Menu =====");
            System.out.println("1. EMI Calculator");
            System.out.println("2. Gratuity Calculator");
            System.out.println("3. Lumpsum Calculator");
            System.out.println("4. PPF Calculator");
            System.out.println("5. SIP Calculator");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 0:
                        System.out.println("Thank you for using the calculator. Goodbye!");
                        return;

                    case 1:
                        new EMICalculator().init();
                        break;

                    case 2:
                        new GratuityCalculator().init();
                        break;

                    case 3:
                        new LumpsumCalculator().init();
                        break;

                    case 4:
                        new PPFCalculator().init();
                        break;

                    case 5:
                        new SIPCalculator().init();
                        break;

                    default:
                        System.out.println("Invalid option! Please select a valid choice from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
