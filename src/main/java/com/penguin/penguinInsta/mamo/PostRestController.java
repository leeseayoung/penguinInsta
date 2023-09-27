package com.penguin.penguinInsta.mamo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.penguin.penguinInsta.mamo.service.PostService;


@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping("/create")
	public Map<String, String> createPost(
			 @RequestParam("content") String content
			 , @RequestParam("imageFile") MultipartFile file
			, HttpSession session) {
		
					//다운 캐스팅
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.addPost(userId, content, file);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	

	
	
	
	
}
