package com.penguin.penguinInsta.mamo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDetail {

	private int id;
	private int userId;
	private String loginId;
	private String content;
	private String imagePath;

	
	
}
