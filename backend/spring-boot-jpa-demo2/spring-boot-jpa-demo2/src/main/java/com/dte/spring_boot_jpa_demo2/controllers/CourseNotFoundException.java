package com.dte.spring_boot_jpa_demo2.controllers;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {
    
    public CourseNotFoundException(Long id) {
        super("Could not find course with id: " + id);
    }
}
