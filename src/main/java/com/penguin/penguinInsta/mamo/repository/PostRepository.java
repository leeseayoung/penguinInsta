package com.penguin.penguinInsta.mamo.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {

	public int insertPost(
			@Param("userId")int userId
			, @Param("title")String title
			, @Param("content") String content);
	
	
}
