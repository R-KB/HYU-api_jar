package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Comment;

@Mapper
public interface CommentMapper {

	List<Comment> selectComments();

	Comment selectCommentById(Integer commentId);

	List<Comment> selectCommentByUser(Integer userId);

	Comment selectCommentByRecipe(Integer recipeId);

	void insert(Comment comment);

	void update(Comment comment);

	void delete(Integer commentId);

}
