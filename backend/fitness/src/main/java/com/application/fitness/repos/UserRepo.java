package com.application.fitness.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.fitness.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Boolean existsByEmail (String email);

	public User findByEmail(String email);

}