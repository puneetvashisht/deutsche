package com.tkhts.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestExample {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testIsPositive(int number) {
        assertTrue(number > 0);
    }
    
    @ParameterizedTest
//    comma-separated values
    @CsvSource({
            "apple, 5",
            "banana, 6",
            "orange, 6"
    })
    public void testStringLength(String input, int expectedLength) {
        assertEquals(expectedLength, input.length());
    }
}

