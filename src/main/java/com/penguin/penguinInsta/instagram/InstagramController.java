package com.penguin.penguinInsta.instagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/user")
@Controller
public class InstagramController {

	
	
	@GetMapping("/join-view")
	public String joinInput() {
		
		return "instagram/join";
	}
	
	
	//로그인 페이지
	@GetMapping("/login-view")
	public String loginInput() {
		
		return "instagram/login";
	}
	
}
