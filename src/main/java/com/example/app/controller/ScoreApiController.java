package com.example.app.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Score;
import com.example.app.service.ScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/score")
public class ScoreApiController {

	private final ScoreService service;

	@GetMapping
	public ResponseEntity<List<Score>> getScores() {
		List<Score> scores = service.getAllScores();
		return new ResponseEntity<>(scores, HttpStatus.OK);
	}

	@GetMapping("/{scoreId}")
	public ResponseEntity<Score> getScoreById(@PathVariable int scoreId) {
		Score score = service.getScoreById(scoreId);
		HttpStatus status = score == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<>(score, status);
	}

	@GetMapping("/recipe/{recipeId}")
	public ResponseEntity<Score> getScoreByRecipe(@PathVariable int recipeId) {
		Score score = service.getScoreByRecipe(recipeId);
		HttpStatus status = score == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<>(score, status);
	}

	@PostMapping
	public ResponseEntity<Void> addScore(@RequestBody @Valid Score score, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.addScore(score);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> editScore(@RequestBody @Valid Score score, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.editScore(score);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{scoreId}")
	public ResponseEntity<Void> deleteScore(@PathVariable int scoreId) {
		service.deleteScore(scoreId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/thumb")
	public ResponseEntity<List<Score>> getScoreOrderByThumbDesc() {
		List<Score> scoreByThumb = service.getScoreOrderByThumbDesc();
		return new ResponseEntity<>(scoreByThumb, HttpStatus.OK);
	}

	@GetMapping("/h")
	public ResponseEntity<List<Score>> getScoreOrderByHDesc() {
		List<Score> scoreByH = service.getScoreOrderByHDesc();
		return new ResponseEntity<>(scoreByH, HttpStatus.OK);
	}

	@GetMapping("/y")
	public ResponseEntity<List<Score>> getScoreOrderByYDesc() {
		List<Score> scoreByY = service.getScoreOrderByYDesc();
		return new ResponseEntity<>(scoreByY, HttpStatus.OK);
	}

	@GetMapping("/u")
	public ResponseEntity<List<Score>> getScoreOrderByUDesc() {
		List<Score> scoreByU = service.getScoreOrderByUDesc();
		return new ResponseEntity<>(scoreByU, HttpStatus.OK);
	}

}
