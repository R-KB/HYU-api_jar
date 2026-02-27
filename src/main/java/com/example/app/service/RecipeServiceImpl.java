package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Recipe;
import com.example.app.mapper.RecipeMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

	private final RecipeMapper mapper;

	@Override
	public List<Recipe> getAllRecipes() {
		return mapper.selectRecipes();
	}

	@Override
	public Recipe getRecipeById(Integer recipeId) {
		return mapper.selectRecipeById(recipeId);
	}

	@Override
	public List<Recipe> getRecipeByUser(Integer userId) {
		return mapper.selectRecipeByUser(userId);
	}

	@Override
	public void addRecipe(Recipe recipe) {
		mapper.insert(recipe);

	}

	@Override
	public void editRecipe(Recipe recipe) {
		mapper.update(recipe);

	}

	@Override
	public void deleteRecipe(Integer recipeId) {
		mapper.delete(recipeId);

	}

	@Override
	public List<Recipe> getRecipesOrderByRecent() {
		return mapper.selectRecipesOrderByRecent();
	}

}
