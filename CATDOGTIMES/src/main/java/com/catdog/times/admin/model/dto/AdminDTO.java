package com.catdog.times.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class AdminDTO {
	// 회원 ----------------------
	private String memberNo; 		// 회원번호
	private String memberId; 		// 회원 ID
	private String memberName; 		// 회원명
	private String memberNickName;  // 회원닉네임
	private String memberType;		// 회원유형
	private String memberEmail;		// 회원이메일
	private String memberCreateDate;// 가입일
	private String memberWarn;		// 경고횟수
	private String memberIs;		// 활성여부
	// --------------------------
	
	// 게시글 --------------------
	private String postId;			// 게시글 ID
	private String postContent; 	// 게시글 내용
	private String postCreateDate;  // 게시글 등록일
	private String postUpdateDate;  // 게시글 수정일
	// --------------------------
	
	// 댓글 ----------------------
	private String replyId;			// 댓글 ID
	private String replyContent;	// 댓글 내용
	private String replyCreatedDate; // 댓글 등록일
	private String replyUpdateDate; // 댓글 수정일
	// --------------------------
	
	// 검색영역 --------------------
	private String srchType;	// 검색유형
	private String srchVal;		// 검색값
	// ---------------------------
}
