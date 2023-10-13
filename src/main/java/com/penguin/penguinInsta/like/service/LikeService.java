package com.penguin.penguinInsta.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penguin.penguinInsta.like.repository.LikeRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	
	
	//좋아요 삭제
	public int deleteLikeByPostIdAndUserId(int postId, int userId) {
		return likeRepository.deleteLikeByPostIdAndUserId(postId, userId);
	}
	
	
	
	
	
	public int addlike(int userId, int postId) {
		return likeRepository.insertLike(userId, postId);
	}
	
	//좋아요 갯수
	public int countLike(int postId) {
		return likeRepository.selectCountLike(postId);
	}
	
	
	
	public boolean isLike(int postId, int userId) {
		 int count = likeRepository.selectCountLikeByUserId(postId, userId);
		 
		 if(count == 0) {
			 return false;
		 } else {
			 return true;
		 }
	
//		 return != 0;
		 
	}
	
	
	//좋아요 삭제
	public int deleteLikeByPostId(int postId) {
		return likeRepository.deleteLikeByPostId(postId);
	}
	
	
}
