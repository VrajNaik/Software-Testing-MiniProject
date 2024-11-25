package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RetirementCorpusCalculatorTest {

    @Test
    public void testcase4() {
        RetirementCorpusCalculator calculator = new RetirementCorpusCalculator();

        int currentAge = 30;
        int retirementAge = 60;
        int lifeExpectancy = 85;
        double currentExpenses = 50000;
        double inflationRate = 6; // 6%
        double returnRate = 8;    // 8%

        // Expected calculations
        int yearsUntilRetirement = retirementAge - currentAge;
        double futureExpenses = currentExpenses * Math.pow(1 + inflationRate / 100, yearsUntilRetirement);
        int retirementYears = lifeExpectancy - retirementAge;
        double expectedCorpus = (futureExpenses * 12) * ((1 - Math.pow(1 + returnRate / 100, -retirementYears)) / (returnRate / 100));

        double calculatedCorpus = calculator.calculateCorpus(currentAge, retirementAge, lifeExpectancy, currentExpenses, inflationRate, returnRate);

        assertEquals(expectedCorpus, calculatedCorpus, 0.01, "The calculated corpus should match the expected value.");
    }

    @Test
    public void testcase1() {
        RetirementCorpusCalculator calculator = new RetirementCorpusCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateCorpus(65, 60, 85, 50000, 6, 8),
                "Expected exception for current age greater than or equal to retirement age."
        );
        assertEquals("Retirement age must be greater than current age.", exception.getMessage());
    }

    @Test
    public void testcase2() {
        RetirementCorpusCalculator calculator = new RetirementCorpusCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateCorpus(30, 60, 55, 50000, 6, 8),
                "Expected exception for life expectancy less than retirement age."
        );
        assertEquals("Life expectancy must be greater than retirement age.", exception.getMessage());
    }

    @Test
    public void testcase3() {
        RetirementCorpusCalculator calculator = new RetirementCorpusCalculator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateCorpus(30, 60, 85, -50000, 6, 8),
                "Expected exception for negative current expenses."
        );
        assertEquals("All financial inputs must be positive values.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateCorpus(30, 60, 85, 50000, -6, 8),
                "Expected exception for negative inflation rate."
        );
        assertEquals("All financial inputs must be positive values.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateCorpus(30, 60, 85, 50000, 6, 0),
                "Expected exception for zero return rate."
        );
        assertEquals("All financial inputs must be positive values.", exception.getMessage());
    }
}
