package com.dte.spring_boot_jpa_demo2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dte.spring_boot_jpa_demo2.entities.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>  {

        Course findByTitleAndPrice(String title, double price);

        List<Course> findByPriceBetween(double minPrice, double maxPrice);

        // find course with description like %?1%
        List<Course> findByDescriptionContaining(String description);  

        // select * from course where title =?1 and price =?2

        // list of courses greater than a given price
        List<Course> findByPriceGreaterThan(double price);
}
