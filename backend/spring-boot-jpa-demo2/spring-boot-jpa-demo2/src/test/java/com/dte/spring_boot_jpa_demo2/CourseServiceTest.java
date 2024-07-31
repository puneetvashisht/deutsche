package com.dte.spring_boot_jpa_demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dte.spring_boot_jpa_demo2.entities.Course;
import com.dte.spring_boot_jpa_demo2.repos.CourseRepository;
import com.dte.spring_boot_jpa_demo2.services.CourseService;

@SpringBootTest
public class CourseServiceTest {

    // Mock CourseRepository
    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    @Test
    public void getCoursesListTest() {

        Course course1 = new Course("Course 1", "Description 1", 100.0);
        Course course2 = new Course("Course 2", "Description 2", 200.0);
        List<Course> courseList = List.of(course1, course2);

        // Mock CourseRepository method to return courseList
        when(courseRepository.findAll()).thenReturn(courseList);


        // Service Method getCourse List is being tested
        List<Course> courses = courseService.getCoursesList();
        System.out.println("Courses: " + courses);

        // verify that the courseRepository method was called once
        verify(courseRepository).findAll();

        // assert that the list of courses is correct
        assertEquals(2, courses.size());
        // verify(null)
    }

}
