package com.penguin.penguinInsta.instagram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penguin.penguinInsta.instagram.domain.User;

@Repository
public interface InstagramRepository extends JpaRepository<User, Integer> {
//jpa
	//SELECT count(1) ... WHERE `loginId` = #{loginId}
	public int countByLoginId(String loginId);
	
	
	// WHERE `loginId` = ?? AND `password` == ?? 하나일때는 옵션녈 사용
	public Optional<User> findByLoginIdAndPassword(String loginId, String password);
	
}
