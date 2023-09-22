package com.penguin.penguinInsta.instagram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penguin.penguinInsta.instagram.domain.User;

@Repository
public interface InstagramRepository extends JpaRepository<User, Integer> {

	//SELECT count(1) ... WHERE `loginId` = #{loginId}
	public int countByLoginId(String loginId);
	
	
	// WHERE `loginId` = ?? AND `password` == ??
	public Optional<User> findByLoginIdAndPassword(String loginId, String password);
	
}
