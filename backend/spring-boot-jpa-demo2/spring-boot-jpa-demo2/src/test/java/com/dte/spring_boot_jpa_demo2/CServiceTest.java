package com.dte.spring_boot_jpa_demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dte.spring_boot_jpa_demo2.services.CourseService;

@SpringBootTest
public class CServiceTest {
    
    @Autowired
    CourseService courseService;

    @Test
    public void someLogicTest() {
        courseService.someLogic();
    }

    @Test
    public void addTest() {
        int sum = courseService.add(5, 10);
        assertEquals(15, sum);
    }
}
