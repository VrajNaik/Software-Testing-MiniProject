package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GoalSavingsCalculatorTest {

    private void testing(String input, String expectedOutputPart) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        GoalSavingsCalculator calculator = new GoalSavingsCalculator();
        calculator.init();
        String actualOutput = byteArrayOutputStream.toString();

        // Assert that the expected part is present in the actual output
        Assert.assertTrue("Output did not contain the expected value: " + expectedOutputPart,
                actualOutput.contains(expectedOutputPart));
    }

    @Test
    public void testCase1() {
        String input = "500000\n10\n8\n600000\nmonthly\n";
        String expectedOutput = "Congratulations! Your current savings are sufficient to achieve your goal.";
        testing(input, expectedOutput);
    }

    @Test
    public void testcase2() {
        String input = "1000000\n5\n8\n200000\nmonthly\n";
        String expectedOutput = "To achieve your goal of ₹1000000.00, you need to save ₹";
        testing(input, expectedOutput);
    }

    @Test
    public void testCase3() {
        String input = "800000\n7\n10\n100000\nannual\n";
        String expectedOutput = "To achieve your goal of ₹800000.00, you need to save ₹";
        testing(input, expectedOutput);
    }
}
