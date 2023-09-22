package com.penguin.penguinInsta.instagram.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penguin.penguinInsta.common.EncryptUtils;
import com.penguin.penguinInsta.instagram.domain.User;
import com.penguin.penguinInsta.instagram.repository.InstagramRepository;

@Service
public class InstagramService {

	@Autowired	
	private InstagramRepository instagramRepository;
	
	
	
	public User getUser(String loginId, String password) {
		
		//암호화
		String encryptPassword = EncryptUtils.md5(password);
		
		//밑에 이렇게도 사용 가능!
		//User user = instagramRepository.findByLoginIdAndPassword(loginId, encryptPassword).orElse(null);
		
		Optional<User> optionalUser = instagramRepository.findByLoginIdAndPassword(loginId, encryptPassword);
		User user = optionalUser.orElse(null);
		
		return user;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//중복확인 boolean == Boolean
	public boolean isDuplicateId(String loginId) {
		
		
		int count = instagramRepository.countByLoginId(loginId);
		
		
		if(count == 0) {
			return false;
			
		} else {
			 return true;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	// 저장 기능
	public User addUser(String loginId
			, String password
			, String name
			, String email) {
		
		
		//비밀번호 암호화
	    String encryptPassword = com.penguin.penguinInsta.common.EncryptUtils.md5(password);
		
		User user = User.builder()
						   //값
						.loginId(loginId)
						.password(encryptPassword)
						.name(name)
						.email(email)
						.build();
		
		
		
		return instagramRepository.save(user);
		
		
	}
	
	

	
	
}
