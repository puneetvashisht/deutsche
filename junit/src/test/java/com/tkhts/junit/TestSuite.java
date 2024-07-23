package com.tkhts.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//@DisplayName("Test Suite")
public class TestSuite {

    @Nested
//    @DisplayName("Calculator Tests")
    class CalculatorTestSuite {
        // Add test classes related to the calculator functionality
    	@Test
        public void testAddition() {
            Calculator calculator = new Calculator();
            int result = calculator.add(2, 3);
            assertEquals(5, result);
        }

        @Test
        public void testSubtraction() {
            Calculator calculator = new Calculator();
            int result = calculator.subtract(5, 2);
            assertEquals(3, result);
        }
    }

//    @Nested
//    @DisplayName("StringUtils Tests")
//    class StringUtilsTestSuite {
//        // Add test classes related to string manipulation
//    }
    
    // Add additional nested classes for more test suites or test classes
}
