package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Recipe {

	private Integer id;
	
	private Integer userId;

	private String title;

	private String img;

	private String ingredient;

	private String recipe;

	private String outro;

	private LocalDateTime registered;

	private LocalDateTime updated;

	private User user;

}
