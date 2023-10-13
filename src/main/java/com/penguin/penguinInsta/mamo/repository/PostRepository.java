package com.penguin.penguinInsta.mamo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.penguin.penguinInsta.mamo.domain.Post;



@Repository
public interface PostRepository {

	
	
	//게시글 정보를 모두 모을려고
	public Post selectPost(@Param("postId")int postId);
	
	
	
	//삭제 
	public int deleteInsta(@Param("postId")int postId);
	
	
	
	
	
	
	
	
	//타이틀업음
	public int insertPost(
			@Param("userId")int userId
			, @Param("content") String content
			, @Param("imagePath")String imagePath);


	public List<Post> selectPostList();

	
	
	
	
	
	
}
