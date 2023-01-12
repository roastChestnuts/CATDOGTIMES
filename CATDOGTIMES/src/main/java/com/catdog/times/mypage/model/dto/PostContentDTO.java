package com.catdog.times.mypage.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PostContentDTO {

	private int postId;
	private String postContent;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date postCreateDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date postUpdateDate;
	
	private int memberNo;

	public PostContentDTO() {}
	
	public PostContentDTO(int postId, String postContent, Date postCreateDate, Date postUpdateDate, int memberNo) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.postCreateDate = postCreateDate;
		this.postUpdateDate = postUpdateDate;
		this.memberNo = memberNo;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostCreateDate() {
		return postCreateDate;
	}

	public void setPostCreateDate(Date postCreateDate) {
		this.postCreateDate = postCreateDate;
	}

	public Date getPostUpdateDate() {
		return postUpdateDate;
	}

	public void setPostUpdateDate(Date postUpdateDate) {
		this.postUpdateDate = postUpdateDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	@Override
	public String toString() {
		return "PostContentDTO [postId=" + postId + ", postContent=" + postContent + ", postCreateDate="
				+ postCreateDate + ", postUpdateDate=" + postUpdateDate + ", memberNo=" + memberNo + "]";
	}


}
