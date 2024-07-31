package com.dte.spring_boot_jpa_demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dte.spring_boot_jpa_demo2.services.CourseService;

@SpringBootApplication
public class SpringBootJpaDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemo2Application.class, args);
	}

	// @Bean
	// public CourseService courseService() {
	// 	return new CourseService();
    // }

}
