package com.application.fitness.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.fitness.entities.ERole;
import com.application.fitness.entities.Role;



public interface RoleRepo extends JpaRepository<Role, Long>{

	Optional<Role> findByName(ERole role);
}
