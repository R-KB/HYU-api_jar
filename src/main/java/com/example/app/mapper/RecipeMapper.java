package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Recipe;

@Mapper
public interface RecipeMapper {
	
	List<Recipe> selectRecipes();
	
	Recipe selectRecipeById(Integer recipeId);
	
	List<Recipe> selectRecipeByUser(Integer userId);
	
	void insert(Recipe recipe);
	
	void update(Recipe recipe);
	
	void delete(Integer recipeId);
	
	List<Recipe> selectRecipesOrderByRecent();
	

}
