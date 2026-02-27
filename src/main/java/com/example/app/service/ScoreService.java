package com.example.app.service;

import java.util.List;

import com.example.app.domain.Score;

public interface ScoreService {

	List<Score> getAllScores();

	Score getScoreById(Integer scoreId);

	Score getScoreByRecipe(Integer recipeId);

	void addScore(Score score);

	void editScore(Score score);

	void deleteScore(Integer scoreId);

	List<Score> getScoreOrderByThumbDesc();

	List<Score> getScoreOrderByHDesc();

	List<Score> getScoreOrderByYDesc();

	List<Score> getScoreOrderByUDesc();

}
