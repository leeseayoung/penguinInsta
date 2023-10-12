package com.penguin.penguinInsta.mamo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.penguin.penguinInsta.comment.dto.CommentDetail;
import com.penguin.penguinInsta.comment.service.CommentService;
import com.penguin.penguinInsta.common.FileManager;
import com.penguin.penguinInsta.instagram.domain.User;
import com.penguin.penguinInsta.instagram.service.InstagramService;
import com.penguin.penguinInsta.like.service.LikeService;
import com.penguin.penguinInsta.mamo.domain.Post;
import com.penguin.penguinInsta.mamo.dto.PostDetail;
import com.penguin.penguinInsta.mamo.repository.PostRepository;



@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private InstagramService instagramService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private CommentService commentService;
	
	
	//삭제 기능
	public int deletePenguinInsat(int postId) {
		return postRepository.deleteInsta(postId);
	}
	
	
	
	
	
	
	
	
	public int addPost(int userId, String content, MultipartFile file) {
		
		String imagePath = FileManager.saveFile(userId, file);
		
		return postRepository.insertPost(userId, content, imagePath);
		
		
	}
	
	
	

	// 이거
	public List<PostDetail> getPostList(int loginUserId) {
		
		
		
		List<Post> postList = postRepository.selectPostList();
		
		List<PostDetail> postDetailList = new ArrayList<>();
		for(Post post:postList) {
			
			
			
			int userId = post.getUserId();
			User user =  instagramService.getUserById(userId);
//			user.getLoginId(); //jsp 이걸 쓸 기능
//			PostDetail postDetail = new PostDetail;
			
			//좋아요 개수 조회
			int likeCount = likeService.countLike(post.getId());
			
			//좋아요 색갈
			boolean isLike = likeService.isLike(post.getId(), loginUserId);
			
			
			//댓글
			List<CommentDetail> commentList = commentService.getCommentList(post.getId());
			
			//
			
			
			PostDetail postDetail = PostDetail.builder()
									.id(post.getId())
									.userId(userId)
									.content(post.getContent())
									.imagePath(post.getImagePath())
									.loginId(user.getLoginId())
									.likecount(likeCount)
									.isLike(isLike)
									.commentList(commentList)
									.build();		

			postDetailList.add(postDetail);

		}
		
		return postDetailList;
		
		
		
	}

	



	
	
	
	
	
	
	
	
}
