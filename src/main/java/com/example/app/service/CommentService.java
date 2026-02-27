package com.example.app.service;

import java.util.List;

import com.example.app.domain.Comment;

public interface CommentService {

	List<Comment> getAllComments();

	Comment getCommentById(Integer commentId);

	List<Comment> getCommentByUser(Integer userId);

	Comment getCommentByRecipe(Integer recipeId);

	void addComment(Comment comment);

	void editComment(Comment comment);

	void deleteComment(Integer commentId);

}
