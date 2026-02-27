package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Comment;
import com.example.app.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentMapper mapper;

	@Override
	public List<Comment> getAllComments() {
		return mapper.selectComments();
	}

	@Override
	public Comment getCommentById(Integer commentId) {
		return mapper.selectCommentById(commentId);
	}

	@Override
	public List<Comment> getCommentByUser(Integer userId) {
		return mapper.selectCommentByUser(userId);
	}

	@Override
	public Comment getCommentByRecipe(Integer recipeId) {
		return mapper.selectCommentByRecipe(recipeId);
	}

	@Override
	public void addComment(Comment comment) {
		mapper.insert(comment);

	}

	@Override
	public void editComment(Comment comment) {
		mapper.update(comment);

	}

	@Override
	public void deleteComment(Integer commentId) {
		mapper.delete(commentId);

	}

}
