package com.application.fitness.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	String workoutName;
	
	String description;
	
	String imgageUrl;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<WorkoutVideo> workoutVideo;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgageUrl() {
		return imgageUrl;
	}

	public void setImgageUrl(String imgageUrl) {
		this.imgageUrl = imgageUrl;
	}

	public List<WorkoutVideo> getWorkoutVideo() {
		return workoutVideo;
	}

	public void setWorkoutVideo(List<WorkoutVideo> workoutVideo) {
		this.workoutVideo = workoutVideo;
	}
	
}
