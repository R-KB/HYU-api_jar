package com.example.app.service;

import java.util.List;

import com.example.app.domain.Recipe;

public interface RecipeService {

	List<Recipe> getAllRecipes();

	Recipe getRecipeById(Integer recipeId);

	List<Recipe> getRecipeByUser(Integer userId);

	void addRecipe(Recipe recipe);

	void editRecipe(Recipe recipe);

	void deleteRecipe(Integer recipeId);
	
	List<Recipe> getRecipesOrderByRecent();

}
