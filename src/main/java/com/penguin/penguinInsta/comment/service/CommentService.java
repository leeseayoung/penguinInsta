package com.penguin.penguinInsta.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penguin.penguinInsta.comment.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	//댓글 기능 추가
	public int addComment(int postId, int userId, String content) {
		return commentRepository.insertComment(userId, postId, content);
		
	}
	
}
