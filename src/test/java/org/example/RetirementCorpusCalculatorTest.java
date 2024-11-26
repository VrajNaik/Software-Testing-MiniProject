package org.example;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class RetirementCorpusCalculatorTest {

    String input1 = "23\n58\n70\n30000\n8\n9\n"; //    [1,2,3,4,6,7,9,10,11,13,14]
    String input2 = "50\n48\n60\n70\n90\n40000\n6\n8\n"; //    [1,2,3,4,5,3,4,6,7,9,10,11,13,14]
    String input3 = "30\n50\n48\n30\n50\n70\n45000\n6\n8\n"; //    [1,2,3,4,6,7,8,3,4,6,7,9,10,11,13,14]
    String input4 = "32\n58\n89\n52000\n7\n0\n52000\n7\n3\n"; //    [1,2,3,4,6,7,9,10,11,12,10,11,13,14]

    public void testing(String input, String expectedMessage) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);

        RetirementCorpusCalculator calculator = new RetirementCorpusCalculator();
        calculator.init();

        // Assuming output is verified by matching part of the expected message in the console output
        // You might need additional helpers to capture and verify console outputs
    }

    @Test
    public void testCase1() {
        testing(input1, "Your estimated retirement corpus: ₹38114563.90\n" +
                "This corpus will support expenses of ₹443560.33 per month post-retirement.");
    }

    @Test
    public void testCase2() {
        testing(input2, "Your estimated retirement corpus: ₹13033667.92\n" +
                "This corpus will support expenses of ₹94694.55 per month post-retirement.");
    }

    @Test
    public void testCase3() {
        testing(input3, "Your estimated retirement corpus: ₹17003589.56\n" +
                "This corpus will support expenses of ₹144321.10 per month post-retirement.");
    }

    @Test
    public void testCase4() {
        testing(input4, "Your estimated retirement corpus: ₹72477317.28\n" +
                "This corpus will support expenses of ₹301982.35 per month post-retirement.");
    }
}