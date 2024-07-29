package com.dte.spring_boot_jpa_demo2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dte.spring_boot_jpa_demo2.entities.Course;

public interface CourseRepository  extends JpaRepository<Course, Long>  {

    
}
