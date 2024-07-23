package com.tkhts.junit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    @Test
    public void testException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            int length = str.length();
        });
    }

    @Test
    public void testArithmeticException() {
        int dividend = 10;
        int divisor = 0;
        assertThrows(ArithmeticException.class, () -> {
            int result = dividend / divisor;
        });
    }

    @Test
    public void testIndexOutOfBoundsException() {
        String[] arr = new String[5];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            String element = arr[10];
        });
    }
}
