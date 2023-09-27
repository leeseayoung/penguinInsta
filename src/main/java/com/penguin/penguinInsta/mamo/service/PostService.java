package com.penguin.penguinInsta.mamo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.penguin.penguinInsta.common.FileManager;
import com.penguin.penguinInsta.instagram.domain.User;
import com.penguin.penguinInsta.instagram.service.InstagramService;
import com.penguin.penguinInsta.mamo.domain.Post;
import com.penguin.penguinInsta.mamo.dto.PostDetail;
import com.penguin.penguinInsta.mamo.repository.PostRepository;



@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private InstagramService instagramService;
	
	
	

	
	
	
	
	
	
	
	public int addPost(int userId, String content, MultipartFile file) {
		
		String imagePath = FileManager.saveFile(userId, file);
		
		return postRepository.insertPost(userId, content, imagePath);
		
		
	}
	
	
	

	// 이거
	public List<PostDetail> getPostList() {
		
		
		
		List<Post> postList = postRepository.selectPostList();
		
		List<PostDetail> postDetailList = new ArrayList<>();
		for(Post post:postList) {
			
			
			
			int userId = post.getUserId();
			User user =  instagramService.getUserById(userId);
//			user.getLoginId(); //jsp 이걸 쓸 기능
//			PostDetail postDetail = new PostDetail;
			
			
			PostDetail postDetail = PostDetail.builder()
									.id(post.getId())
									.userId(userId)
									.content(post.getContent())
									.imagePath(post.getImagePath())
									.loginId(user.getLoginId())
									.build();		

			postDetailList.add(postDetail);

		}
		
		return postDetailList;
		
		
		
	}

	



	
	
	
	
	
	
	
	
}
