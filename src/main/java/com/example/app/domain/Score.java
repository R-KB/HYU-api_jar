package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Score {
	
	private Integer id;
	
	private Integer thumb;
	
	private Integer pointH;
	
	private Integer pointY;
	
	private Integer pointU;
	
	private LocalDateTime registered;
	
	private LocalDateTime updated;
	
	private Recipe recipe;

}
