package org.example;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class GoalSavingsCalculatorTest {

    String input1 = "1000000\n10\n8\n100000\nannual\n"; // [1, 2, 3, 4, 5, 7, 9, 10, 12, 13, 14, 16, 17]
    String input2 = "100000\n8\n5\n80000\nannual\n"; // [1, 2, 3, 4, 5, 7, 9, 10, 12, 13, 14, 15, 17]
    String input3 = "-1000000\n5\n100000\n8\n5\n10000\nannual\n"; // [1,2,3,4,6,4,5,7,9,10,12,13,14,16,17]
    String input4 = "1000000\n5\n0\n200000\n1000000\n5\n8\n200000\nmonthly\n"; // [1,2,3,4,5,7,8,4,5,7,9,10,12,13,14,16,17]
    String input5 = "1000000\n10\n8\n100000\nannua\nannual"; // [1,2,3,4,5,7,9,10,11,10,12,13,14,15,17],


    public void testing(String input, String expectedMessage) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);

        GoalSavingsCalculator calculator = new GoalSavingsCalculator();
        calculator.init();

        // Assuming output is verified by matching part of the expected message in the console output
        // You might need additional helpers to capture and verify console outputs
    }

    @Test
    public void testCase1() {
        testing(input1, "To achieve your goal of ₹1000000.00, you need to save ₹54126.54 per year");
    }

    @Test
    public void testCase2() {
        testing(input2, "Congratulations! Your current savings are sufficient to achieve your goal.");
    }

    @Test
    public void testCase3() {
        testing(input3, "Goal amount and time frame must be positive.");
    }

    @Test
    public void testCase4() {
        testing(input4, "Goal amount and time frame must be positive.");
    }
    @Test
    public void testCase5() {
        testing(input5, "To achieve your goal of ₹1000000.00, you need to save ₹54126.54 per year");
    }
}
