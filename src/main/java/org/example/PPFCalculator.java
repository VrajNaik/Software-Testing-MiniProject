package org.example;

import java.util.Scanner;

public class PPFCalculator {
    private Double yearlyInvestmentAmount;      // Yearly investment definition
    private Double timePeriodInYears;           // Time period in years definition
    private final Double rateOfInterestInPercentage; // Fixed interest rate

    public Double getYearlyInvestmentAmount() {
        return yearlyInvestmentAmount; // Use: accessing yearly investment
    }

    public void setYearlyInvestmentAmount(Double yearlyInvestmentAmount) {
        this.yearlyInvestmentAmount = yearlyInvestmentAmount; // Definition: assigning yearly investment
    }

    public Double getTimePeriodInYears() {
        return timePeriodInYears; // Use: accessing time period
    }

    public void setTimePeriodInYears(Double timePeriodInYears) {
        this.timePeriodInYears = timePeriodInYears; // Definition: assigning time period
    }

    public Double getRateOfInterestInPercentage() {
        return rateOfInterestInPercentage; // Use: accessing interest rate
    }

    public PPFCalculator() {
        this.rateOfInterestInPercentage = 7.1; // Default interest rate
    }

    public Long init() {
        Scanner scanner = new Scanner(System.in);

        // Investment Prompt and Assignment
        Double investmentStep1 = readPositiveDouble(scanner, "Enter your yearly investment amount (Step 1): ");
        Double investmentStep2 = validatePositiveInvestment(investmentStep1);
        Double investmentFinal = assignYearlyInvestment(investmentStep2);

        // Time Period Prompt and Assignment
        Double timeStep1 = readPositiveDouble(scanner, "Enter the time period for investment (Step 1): ");
        Double timeStep2 = validatePositiveTime(timeStep1);
        Double timeFinal = assignTimePeriod(timeStep2);

        // Assign final values
        setYearlyInvestmentAmount(investmentFinal);
        setTimePeriodInYears(timeFinal);

        // Perform Calculation
        Long totalValue = calculateReturn();
        displayFinalResult(totalValue);
        return totalValue;
    }

    private Double readPositiveDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return parseDouble(input);
    }

    private Double parseDouble(String input) {
        return Double.parseDouble(input.trim());
    }

    private Double validatePositiveInvestment(Double investment) {
        Double validatedInvestment = investment;
        if (validatedInvestment <= 0) {
            validatedInvestment = defaultInvestmentValue();
        }
        return validatedInvestment;
    }

    private Double validatePositiveTime(Double time) {
        Double validatedTime = time;
        if (validatedTime <= 0) {
            validatedTime = defaultTimeValue();
        }
        return validatedTime;
    }

    private Double assignYearlyInvestment(Double investment) {
        Double assignedInvestment = investment;
        yearlyInvestmentAmount = assignedInvestment; // Assign to instance field
        return assignedInvestment;
    }

    private Double assignTimePeriod(Double time) {
        Double assignedTime = time;
        timePeriodInYears = assignedTime; // Assign to instance field
        return assignedTime;
    }

    private Double defaultInvestmentValue() {
        return 5000.0; // Default value for invalid investments
    }

    private Double defaultTimeValue() {
        return 1.0; // Default value for invalid time periods
    }

    private void displayFinalResult(Long totalValue) {
        System.out.println("Your total value will be: " + totalValue);
    }

    public Long calculateReturn() {
        Double baseInvestment = yearlyInvestmentAmount;
        Double effectiveRate = rateOfInterestInPercentage / 100;
        Double compoundFactor = Math.pow(1 + effectiveRate, timePeriodInYears);
        Double totalInvestment = baseInvestment * ((compoundFactor - 1) / effectiveRate);

        Double roundedInvestment = Math.floor(totalInvestment); // Explicit step
        return roundedInvestment.longValue();
    }
}
