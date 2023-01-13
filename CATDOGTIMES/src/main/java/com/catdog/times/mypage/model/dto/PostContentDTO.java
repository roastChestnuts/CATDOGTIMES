package com.catdog.times.mypage.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PostContentDTO {

	private int postId;
	private String postContent;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date postCreateDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date postUpdateDate;
	
	private int memberNo;
	
	private int imageId;	
	private String imageSavedName;
	private String imageOriginalName;
	private int replyCnt;
	private int likeCnt;
	private String memberNickname;
}
