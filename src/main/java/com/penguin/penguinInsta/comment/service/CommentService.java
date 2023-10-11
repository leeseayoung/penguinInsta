package com.penguin.penguinInsta.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penguin.penguinInsta.comment.domain.Comment;
import com.penguin.penguinInsta.comment.dto.CommentDetail;
import com.penguin.penguinInsta.comment.repository.CommentRepository;
import com.penguin.penguinInsta.instagram.domain.User;
import com.penguin.penguinInsta.instagram.service.InstagramService;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private InstagramService instagramService;
	
	//댓글 기능 추가
	public int addComment(int userId, int postId, String content) {
		return commentRepository.insertComment(userId, postId, content);
		
	}
	
	public List<CommentDetail> getCommentList(int postId) {
		
	    List<Comment> commentList = commentRepository.selectCommentList(postId);
	    
	    List<CommentDetail> commentDetailList = new ArrayList<>();
	    for(Comment comment:commentList) {
	    	
	    	int userId = comment.getUserId();
	    	User user = instagramService.getUserById(userId);
	    	
	    	CommentDetail commentDetail = CommentDetail.builder()
						    				.id(comment.getId())
						    				.userId(comment.getUserId())
						    				.content(comment.getContent())
						    				.loginId(user.getLoginId())
						    				.build();
	    	
	    	commentDetailList.add(commentDetail);
	    	
	    }
	    
	    
	    return commentDetailList;
	    
	}

	
	
}
