package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Score;

@Mapper
public interface ScoreMapper {

	List<Score> selectScores();

	Score selectScoreById(Integer scoreId);

	Score selectScoreByRecipe(Integer recipeId);

	void insert(Score score);

	void update(Score score);

	void delete(Integer scoreId);

	List<Score> selectScoreOrderByThumbDesc();

	List<Score> selectScoreOrderByHDesc();

	List<Score> selectScoreOrderByYDesc();

	List<Score> selectScoreOrderByUDesc();

}
