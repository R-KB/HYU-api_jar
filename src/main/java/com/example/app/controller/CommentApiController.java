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

import com.example.app.domain.Comment;
import com.example.app.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentApiController {

	private final CommentService service;

	@GetMapping
	public ResponseEntity<List<Comment>> getComments() {
		List<Comment> comments = service.getAllComments();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

	@GetMapping("/{commentId}")
	public ResponseEntity<Comment> getCommentById(@PathVariable int commentId) {
		Comment comment = service.getCommentById(commentId);
		HttpStatus status = comment == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<>(comment, status);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Comment>> getCommentByUser(@PathVariable int userId) {
		List<Comment> comments = service.getCommentByUser(userId);
		HttpStatus status = comments == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<>(comments, status);
	}

	@GetMapping("/{recipeId}")
	public ResponseEntity<Comment> getCommentByRecipe(@PathVariable int recipeId) {
		Comment comment = service.getCommentByRecipe(recipeId);
		HttpStatus status = comment == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<>(comment, status);
	}

	@PostMapping
	public ResponseEntity<Void> addComment(@RequestBody @Valid Comment comment, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.addComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> editComment(@RequestBody @Valid Comment comment, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.editComment(comment);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{commentId}")
	public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
		service.deleteComment(commentId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
