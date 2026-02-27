package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Score;
import com.example.app.mapper.ScoreMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

	private final ScoreMapper mapper;

	@Override
	public List<Score> getAllScores() {
		return mapper.selectScores();
	}

	@Override
	public Score getScoreById(Integer scoreId) {
		return mapper.selectScoreById(scoreId);
	}

	@Override
	public Score getScoreByRecipe(Integer recipeId) {
		return mapper.selectScoreByRecipe(recipeId);
	}

	@Override
	public void addScore(Score score) {
		mapper.insert(score);

	}

	@Override
	public void editScore(Score score) {
		mapper.update(score);

	}

	@Override
	public void deleteScore(Integer scoreId) {
		mapper.delete(scoreId);

	}

	@Override
	public List<Score> getScoreOrderByThumbDesc() {
		return mapper.selectScoreOrderByThumbDesc();
	}

	@Override
	public List<Score> getScoreOrderByHDesc() {
		return mapper.selectScoreOrderByHDesc();
	}

	@Override
	public List<Score> getScoreOrderByYDesc() {
		return mapper.selectScoreOrderByYDesc();
	}

	@Override
	public List<Score> getScoreOrderByUDesc() {
		return mapper.selectScoreOrderByUDesc();
	}

}
