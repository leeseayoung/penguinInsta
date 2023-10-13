package com.penguin.penguinInsta.like.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository {

	
	//좋아요 취소 기능!
	public int deleteLikeByPostIdAndUserId(
			@Param("postId")int postId
			, @Param("userId")int userId);
	
	
	
	
	public int insertLike(
			@Param("userId")int userId
			, @Param("postId") int postId);
	
	//좋아요 갯수
	public int selectCountLike(
			@Param("postId")int postId);
	
	
	public int selectCountLikeByUserId(
			@Param("postId") int postId
			, @Param("userId")int userId);
	
	
	
	//좋아요 삭제
	public int deleteLikeByPostId(@Param("postId")int postId);
}
