package com.penguin.penguinInsta.mamo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.penguin.penguinInsta.mamo.dto.PostDetail;
import com.penguin.penguinInsta.mamo.service.PostService;
@RequestMapping("/post")
@Controller
public class MemoController {

	@Autowired
	private PostService postService;
	
	
	
	@GetMapping("/newpost-view")
	public String postInput() {
		
		return "post/input";
	}
	
	
	
	
	@GetMapping("/timeline-view") 
	public String postTimeline(Model model) {
		
		List<PostDetail> postList = postService.getPostList();
		
		model.addAttribute("postList", postList);
		return "post/timeline";
	}
	
	
	
	

	
	
	
}
