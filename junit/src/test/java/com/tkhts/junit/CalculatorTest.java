package com.tkhts.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @BeforeAll
    public static void setUpBeforeAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    public void setUpBeforeEach() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDownAfterEach() {
        System.out.println("After each test");
    }

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

    @Test
    public void testConcat(){
        Calculator calculator = new Calculator();
        String result = calculator.concat("abc", "xyz");
        assertEquals("abcxyz", result);
    }
}
