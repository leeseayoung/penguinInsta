package com.penguin.penguinInsta.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penguin.penguinInsta.instagram.domain.User;

@Repository
public interface InstagramRepository extends JpaRepository<User, Integer> {

}
