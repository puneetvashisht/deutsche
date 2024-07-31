
// package declaration

package com.dte.spring_boot_jpa_demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dte.spring_boot_jpa_demo2.entities.Course;
import com.dte.spring_boot_jpa_demo2.repos.CourseRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import slf4j;


@Service
// @Slf4j
public class CourseService implements ICourseService{


        @Autowired
    CourseRepository courseRepository;

    public List<Course> getCoursesList(){
        return courseRepository.findAll();
    }

    Logger log = LoggerFactory.getLogger(CourseService.class);
    public void someLogic(){
        // System.out.println("CourseService logic here... 12345678901234");
        log.debug("CourseService logic here... 12345678901234");
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
    } 


    public int add(int x, int y){
        return x + y;
    }
    
}
