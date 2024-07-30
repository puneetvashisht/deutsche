package com.dte.spring_boot_jpa_demo2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dte.spring_boot_jpa_demo2.entities.Course;
import com.dte.spring_boot_jpa_demo2.repos.CourseRepository;
import com.dte.spring_boot_jpa_demo2.services.CourseService;
import com.dte.spring_boot_jpa_demo2.services.ICourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    
    @Autowired
    CourseRepository courseRepository;

    // CourseService courseService = new CourseService();

    @Autowired
    ICourseService courseService;

    @GetMapping("/")
    public List<Course> getCoursesList(){
        return courseRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)  // 201 Created status code indicates that the request has
    @PostMapping("/")
    public void addCourse(@RequestBody Course course) {
        courseService.someLogic();  // call service method if needed

       // course.setId(null);  // if id is not provided by client, set it to null in entity before saving
       courseRepository.save(course);
    }

    @PatchMapping("/{id}")
    public void updateCoursePrice(@PathVariable Long id, @RequestBody Course course){
        Optional<Course> courseFound =  courseRepository.findById(id);
        if(courseFound.isPresent()){
            Course c = courseFound.get();
            c.setPrice(course.getPrice());
            courseRepository.save(c);
        }
        else{
            throw new CourseNotFoundException(id);
        }
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        // return courseRepository.findById(id).orElseThrow(new RuntimeException("Course not found with id: " + id)  );
        // find by id else throw custom exception
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @GetMapping("/search")
    public Course fetchCourseByTitle(@RequestParam String title, @RequestParam double price) {
        System.out.println("title to be fetched: " + title);
        return courseRepository.findByTitleAndPrice(title, price);

    }

    @GetMapping("/price_range")
    public List<Course> fetchCourseByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return courseRepository.findByPriceBetween(minPrice, maxPrice);
    }
    

    @ResponseStatus(HttpStatus.NO_CONTENT) 
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
    

}
