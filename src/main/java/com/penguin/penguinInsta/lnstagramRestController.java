package com.penguin.penguinInsta;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.penguin.penguinInsta.instagram.domain.User;
import com.penguin.penguinInsta.instagram.service.InstagramService;



@RestController  //@Controller + @ResponsseBody
@RequestMapping("/user")
public class lnstagramRestController {

	
	@Autowired
	private InstagramService instagramService;
	
	
	@GetMapping("/duplicate-id")
	public Map<String, Boolean> duplicateId(@RequestParam("loginId") String loginId) {
		
		boolean isDuplicate = instagramService.isDuplicateId(loginId);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		//"isDuplicate e 빼먹음
		if(isDuplicate) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
	}

	

	
	
	
	
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			,	@RequestParam("password") String password
			, 	@RequestParam("name") String name
			, 	@RequestParam("email") String email) { 
		
		User user = instagramService.addUser(loginId, password, name, email);
		
		
		Map<String, String> resultMap  = new HashMap<>();
		
		if(user != null) {
			resultMap.put("result", "success");
			
		} else {
			resultMap.put("result", "fail");
			
		}
		
		return resultMap;
		
	}
	
	
	
}
