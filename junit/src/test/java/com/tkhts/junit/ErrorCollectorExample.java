package com.tkhts.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorCollectorExample {
	
//	 @Test
//	    public void testMultipleErrors() {
//	        assertAll("Multiple Errors",
//	            () -> assertEquals(5, 2 + 2, "Sum is incorrect"),
//	            () -> assertEquals(10, 3 * 3, "Product is incorrect"),
//	            () -> assertEquals("Hello", "World", "Strings do not match")
//	        );
//	    }

    @Test
    public void testMultipleErrors() {
        assertAll("Multiple Errors",
            () -> collectError(() -> assertEquals(5, 2 + 2, "Sum is incorrect")),
            () -> collectError(() -> assertEquals(10, 3 * 3, "Product is incorrect")),
            () -> collectError(() -> assertEquals("Hello", "World", "Strings do not match"))
        );
    }

    private void collectError(Executable executable) {
        try {
            executable.execute();
        } catch (Throwable t) {
            // Collect and handle the error
            System.out.println("Error: " + t.getMessage());
        }
    }
}

