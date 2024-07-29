package com.dte.spring_boot_jpa_demo2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dte.spring_boot_jpa_demo2.entities.Course;
import com.dte.spring_boot_jpa_demo2.repos.CourseRepository;
import com.dte.spring_boot_jpa_demo2.services.CourseService;
import com.dte.spring_boot_jpa_demo2.services.ICourseService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class CourseController {
    
    @Autowired
    CourseRepository courseRepository;

    // CourseService courseService = new CourseService();

    @Autowired
    ICourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCoursesList(){
        return courseRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)  // 201 Created status code indicates that the request has
    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course) {
        courseService.someLogic();  // call service method if needed

       // course.setId(null);  // if id is not provided by client, set it to null in entity before saving
       courseRepository.save(course);
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id){
        // return courseRepository.findById(id).orElseThrow(new RuntimeException("Course not found with id: " + id)  );
        // find by id else throw custom exception
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) 
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
    

}
