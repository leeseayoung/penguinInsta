package com.penguin.penguinInsta.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/post")
@Controller
public class CommentController {

	
	@GetMapping("/comment/create")
	public String createComment() {
		
		
	}
	
	
	
}
