package com.penguin.penguinInsta.mamo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.penguin.penguinInsta.mamo.domain.Post;



@Repository
public interface PostRepository {

	public int insertPost(
			@Param("userId")int userId
			, @Param("title")String title
			, @Param("content") String content);
	
	
	
	
	public List<Post> selectPostList(@Param("userId")int userId);
}
