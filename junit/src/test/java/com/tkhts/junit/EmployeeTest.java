package com.tkhts.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
    
    @Test
    public void firstTest(){
        assertSame(3, 3);
        assertTrue(true);
    }
    @Test
    public void testIncrementSalary(){
        Employee employee = new Employee(12, "Ravi", 10000.00);
        double result = employee.incrementSalary();
        assertEquals(11000.00, result);
        assertTrue(result > 0);
        // assertNotNull(result);
        
    }
}
