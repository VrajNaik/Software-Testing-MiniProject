package org.example;

import java.util.*;

/**
 * Budget Planning Calculator with Nested Conditions
 *
 * Helps users allocate income across fixed expenses, variable expenses,
 * emergency funds, savings goals, and discretionary funds.
 */
public class BudgetPlanningCalculator {

    /**
     * Entry point for integration into a menu-driven system.
     */
    public void init() {
        runBudgetPlanner();
    }

    /**
     * Main method to execute the budget planner.
     */
    public void runBudgetPlanner() {
        Scanner scanner = new Scanner(System.in);

        double monthlyIncome = 0.0;
        double emergencyFundGoal = 0.0;
        double savingsGoal = 0.0;

        Map<String, Double> fixedExpenses = new LinkedHashMap<>();
        Map<String, Double> variableExpenses = new LinkedHashMap<>();

        System.out.println("\n=========== NESTED BUDGET PLANNING CALCULATOR ===========");
        System.out.println("Plan your finances with detailed goal prioritization!");

        // Input monthly income
        while (true) {
            try {
                System.out.print("Enter your monthly income (₹): ");
                monthlyIncome = scanner.nextDouble();
                if (monthlyIncome <= 0) {
                    System.out.println("Income must be greater than zero. Please try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }

        // Input financial goals
        emergencyFundGoal = inputGoal(scanner, "emergency fund");
        savingsGoal = inputGoal(scanner, "savings");

        // Input expenses
        System.out.println("\nEnter your fixed monthly expenses (e.g., rent, utilities):");
        collectExpenses(scanner, fixedExpenses);

        System.out.println("\nEnter your variable monthly expenses (e.g., dining, shopping):");
        collectExpenses(scanner, variableExpenses);

        // Expense calculation
        double totalFixedExpenses = calculateTotal(fixedExpenses);
        double totalVariableExpenses = calculateTotal(variableExpenses);
        double totalExpenses = totalFixedExpenses + totalVariableExpenses;

        // Budget allocation
        double emergencyFundAllocation = 0.0;
        double savingsAllocation = 0.0;
        double discretionaryFunds = 0.0;

        if (totalExpenses <= monthlyIncome) {
            emergencyFundAllocation = Math.min(emergencyFundGoal / 12, monthlyIncome * 0.1);

            // Nested conditions for savings allocation
            if (monthlyIncome - totalExpenses - emergencyFundAllocation > 0) {
                savingsAllocation = Math.min(savingsGoal / 12, (monthlyIncome - totalExpenses - emergencyFundAllocation) * 0.5);

                if (monthlyIncome - totalExpenses - emergencyFundAllocation - savingsAllocation > 0) {
                    discretionaryFunds = monthlyIncome - totalExpenses - emergencyFundAllocation - savingsAllocation;
                } else {
                    discretionaryFunds = 0;
                }
            } else {
                savingsAllocation = 0;
                discretionaryFunds = 0;
            }
        } else {
            System.out.println("\nWarning: Your expenses exceed your income. Consider reducing expenses.");
        }

        // Output results
        System.out.println("\n=========== BUDGET SUMMARY ===========");
        System.out.printf("Total Fixed Expenses: ₹%.2f%n", totalFixedExpenses);
        System.out.printf("Total Variable Expenses: ₹%.2f%n", totalVariableExpenses);
        System.out.printf("Total Expenses: ₹%.2f%n", totalExpenses);
        System.out.printf("Emergency Fund Allocation: ₹%.2f%n", emergencyFundAllocation);
        System.out.printf("Savings Allocation: ₹%.2f%n", savingsAllocation);
        System.out.printf("Discretionary Funds: ₹%.2f%n", discretionaryFunds);

        // Nested evaluation of financial health
        if (totalExpenses > monthlyIncome) {
            System.out.println("\nAlert: Your expenses exceed your income by ₹" + (totalExpenses - monthlyIncome));
        } else if (discretionaryFunds > 0) {
            if (emergencyFundAllocation >= emergencyFundGoal / 12 && savingsAllocation >= savingsGoal / 12) {
                System.out.println("Congratulations! You are meeting all your financial goals this month.");
            } else if (emergencyFundAllocation < emergencyFundGoal / 12 && savingsAllocation >= savingsGoal / 12) {
                System.out.println("You are meeting your savings goal but falling short on your emergency fund.");
            } else if (emergencyFundAllocation >= emergencyFundGoal / 12 && savingsAllocation < savingsGoal / 12) {
                System.out.println("You are meeting your emergency fund goal but falling short on savings.");
            } else {
                System.out.println("You are falling short on both emergency fund and savings goals. Reassess your budget.");
            }
        } else {
            System.out.println("You have no discretionary funds left after expenses and allocations.");
        }

        // Suggestions loop
        while (true) {
            System.out.print("\nWould you like suggestions to adjust your budget? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                suggestBudgetAdjustments(totalFixedExpenses, totalVariableExpenses, monthlyIncome);
                break;
            } else if (response.equalsIgnoreCase("no")) {
                System.out.println("Thank you for using the Budget Planner. Stay financially healthy!");
                break;
            } else {
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
            }
        }
    }

    // Method to input financial goals
    private double inputGoal(Scanner scanner, String goalName) {
        double goal = 0.0;
        while (true) {
            try {
                System.out.print("Enter your " + goalName + " goal (₹): ");
                goal = scanner.nextDouble();
                if (goal < 0) {
                    System.out.println(goalName + " goal cannot be negative. Try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
        return goal;
    }

    // Method to collect expenses
    private void collectExpenses(Scanner scanner, Map<String, Double> expenses) {
        while (true) {
            System.out.print("Enter an expense name (or type 'done' to finish): ");
            String expenseName = scanner.next();
            if (expenseName.equalsIgnoreCase("done")) break;

            System.out.print("Enter the amount for " + expenseName + " (₹): ");
            try {
                double amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount cannot be negative. Try again.");
                } else {
                    expenses.put(expenseName, amount);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Method to calculate total expenses
    private double calculateTotal(Map<String, Double> expenses) {
        double total = 0.0;
        for (double amount : expenses.values()) {
            total += amount;
        }
        return total;
    }

    // Method to suggest budget adjustments
    private void suggestBudgetAdjustments(double fixedExpenses, double variableExpenses, double income) {
        System.out.println("\n=== Budget Adjustment Suggestions ===");
        if (fixedExpenses > income * 0.5) {
            System.out.println("1. Your fixed expenses are high. Consider negotiating rent or cutting utilities.");
        }
        if (variableExpenses > income * 0.3) {
            System.out.println("2. Your variable expenses are high. Consider reducing discretionary spending.");
        }
        System.out.println("3. Aim to allocate at least 20% of your income to savings and emergency funds.");
    }
}
