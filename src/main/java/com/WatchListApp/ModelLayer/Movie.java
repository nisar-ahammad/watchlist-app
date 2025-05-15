package com.WatchListApp.ModelLayer;


import com.WatchListApp.ModelLayer.Validation.Priority;
import com.WatchListApp.ModelLayer.Validation.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Pls enter the title below")
	private String title;
	
	@Rating
	private float rating;
	
	@Priority
	@NotBlank(message = "Pls enter the priority below")
	private String priority;
	
	@Size(max = 50,message = "Size maximum upto 50 character")
	@NotBlank(message = "Pls enter the comment below")
	private String comment;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
