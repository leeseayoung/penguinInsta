package com.penguin.penguinInsta.mamo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/post")
@Controller
public class MomoController {

	
	@GetMapping("/newpost-view")
	public String postInput() {
		
		return "memo/input";
	}
	
	
}
