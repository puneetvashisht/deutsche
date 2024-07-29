
// package declaration

package com.dte.spring_boot_jpa_demo2.services;

import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService{
    public void someLogic(){
        System.out.println("CourseService logic here... 12345678901234");
    } 
}
