package com.dte.spring_boot_jpa_demo2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dte.spring_boot_jpa_demo2.entities.Course;

public interface CourseRepository  extends JpaRepository<Course, Long>  {

        Course findByTitleAndPrice(String title, double price);

        List<Course> findByPriceBetween(double minPrice, double maxPrice);

        // select * from course where title =?1 and price =?2
}
