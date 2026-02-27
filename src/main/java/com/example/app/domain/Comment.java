package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Comment {
	
	private Integer id;
	
	private String comment;
	
	private LocalDateTime registered;
	
	private LocalDateTime updated;
	
	private Recipe recipe;
	
	private User user;
}
