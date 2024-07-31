package com.application.fitness.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.fitness.entities.Workout;

public interface WorkoutRepo extends JpaRepository<Workout, Integer> {

}
