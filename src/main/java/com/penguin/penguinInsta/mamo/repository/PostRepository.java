package com.penguin.penguinInsta.mamo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.penguin.penguinInsta.mamo.domain.Post;



@Repository
public interface PostRepository {

	//타이틀업음
	public int insertPost(
			@Param("userId")int userId
			, @Param("content") String content
			, @Param("imagePath")String imagePath);
	
	
	
	
	
}
