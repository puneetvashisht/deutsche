package com.dte.spring_boot_jpa_demo2;


import com.dte.spring_boot_jpa_demo2.entities.Course;
import com.dte.spring_boot_jpa_demo2.repos.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testGetAllCourses() throws Exception {
        mockMvc.perform(get("/api/v1/courses/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFetchCourse() throws Exception {
        Course course = new Course("Test Course", "description", 100.0);
        course = courseRepository.save(course);

        mockMvc.perform(get("/api/v1/courses/" + course.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Course"))
                .andExpect(jsonPath("$.price").value(100.0));
    }

    @Test
    public void testCourseByTitleAndPrice() throws Exception {
        Course course = new Course("Test Course", "description", 100.0);
        course = courseRepository.save(course);
        mockMvc.perform(get("/api/v1/courses/search?title=" + course.getTitle() + "&price=" + course.getPrice()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Test Course"))
        .andExpect(jsonPath("$.price").value(100.0));
    }


    // @Test
    // public void testGetCategoryById() throws Exception {
    //     Category category = new Category("Electronics");
    //     category = categoryRepository.save(category);

    //     mockMvc.perform(get("/categories/" + category.getId()))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.name").value("Electronics"));
    // }

    // @Test
    // public void testCreateCategory() throws Exception {
    //     Category category = new Category("Books");

    //     mockMvc.perform(post("/categories")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(category)))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.name").value("Books"));
    // }

    // @Test
    // public void testUpdateCategory() throws Exception {
    //     Category category = new Category("Clothing");
    //     category = categoryRepository.save(category);

    //     Category updatedCategory = new Category("Fashion");

    //     mockMvc.perform(put("/categories/" + category.getId())
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(updatedCategory)))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.name").value("Fashion"));
    // }

    // @Test
    // public void testDeleteCategory() throws Exception {
    //     Category category = new Category("Gadgets");
    //     category = categoryRepository.save(category);

    //     mockMvc.perform(delete("/categories/" + category.getId()))
    //             .andExpect(status().isOk());
    // }
}
