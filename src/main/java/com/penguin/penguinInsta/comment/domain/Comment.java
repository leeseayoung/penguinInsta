package com.penguin.penguinInsta.comment.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.penguin.penguinInsta.instagram.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name="comment")
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	private String userId;
	
	private String postId;
	
	private String contnet;
	
	
	@UpdateTimestamp	
	@Column(name="createdAt", updatable=false)
	private Date createdAt;
	
	
	@UpdateTimestamp	
	@Column(name="updatedAt")
	private Date updatedAt;
}
