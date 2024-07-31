package com.application.fitness.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.fitness.entities.Workout;
import com.application.fitness.repos.WorkoutRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FitnessRestController {
	
	@Autowired
	WorkoutRepo  workoutRepo;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("/workout")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addWorkout(@RequestBody Workout workout){	
		workoutRepo.save(workout);
		ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.CREATED);
		return re;
	}
	
	@PutMapping("/workoutVideo/{workoutName}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addWorkoutVideo(@PathVariable
			@RequestParam(value = "empJson", required = true) String empJson,
			@RequestParam("file") MultipartFile file)
					throws JsonParseException, JsonMappingException, IOException, ServletException{
		
		Workout w = objectMapper.readValue(empJson, Workout.class);
		workoutRepo.save(w);
		ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.CREATED);
		return re;
	}
}
