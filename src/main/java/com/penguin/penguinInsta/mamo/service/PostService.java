package com.penguin.penguinInsta.mamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.penguin.penguinInsta.mamo.domain.Post;
import com.penguin.penguinInsta.mamo.repository.PostRepository;



@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public int addPost(int userId, String title, String content) {
		
		return postRepository.insertPost(userId, title, content);
		
	}
	
	
	
	// 이거
	public List<Post> getPostList() {
		
		return postRepository.selectPostList();
		
	}

	
	
	
	
	
	
	
	
}
