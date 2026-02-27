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

import com.example.app.domain.Recipe;
import com.example.app.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipe")
public class RecipeApiController {

	private final RecipeService service;

	@GetMapping
	public ResponseEntity<List<Recipe>> getRecipes() {
		List<Recipe> recipes = service.getAllRecipes();
		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping("/{recipeId}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable int recipeId) {
		Recipe recipe = service.getRecipeById(recipeId);
		HttpStatus status = recipe == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
		return new ResponseEntity<>(recipe, status);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Recipe>> getRecipeByUser(@PathVariable int userId) {
		List<Recipe> recipes = service.getRecipeByUser(userId);
		HttpStatus status = recipes == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(recipes, status);
	}

	@PostMapping
	public ResponseEntity<Void> addRecipe(@RequestBody @Valid Recipe recipe, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.addRecipe(recipe);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> editRecipe(@RequestBody @Valid Recipe recipe, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.editRecipe(recipe);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{recipeId}")
	public ResponseEntity<Void> deleteRecipe(@PathVariable int recipeId) {
		service.deleteRecipe(recipeId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/recent")
	public ResponseEntity<List<Recipe>> getRecipesOrderByRecent() {
		List<Recipe> recent = service.getRecipesOrderByRecent();
		return new ResponseEntity<>(recent, HttpStatus.OK);
	}

}
