package com.catdog.times.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class AdminDTO {
	// 회원 ----------------------
	private String memberNo; 			// 회원번호
	private String memberId; 			// 회원 ID
	private String memberName; 			// 회원명
	private String memberNickName;  	// 회원닉네임
	private String memberType;			// 회원유형
	private String memberEmail;			// 회원이메일
	private String memberCreateDate;	// 가입일
	private String memberWarn;			// 경고횟수
	private String memberIs;			// 활성여부
	// --------------------------
	
	// 게시글 --------------------
	private String postId;				// 게시글 ID
	private String postContent; 		// 게시글 내용
	private String postCreateDate;  	// 게시글 등록일
	private String postUpdateDate;  	// 게시글 수정일
	private String postShowYn;			// 게시글 노출 여부
	private int replyCnt;				// 게시글 댓글수
	// --------------------------
	
	// 댓글 ----------------------
	private String replyId;				// 댓글 ID
	private String replyContent;		// 댓글 내용
	private String replyCreatedDate;	// 댓글 등록일
	private String replyUpdateDate;		// 댓글 수정일
	// --------------------------	
	
	// 검색영역 --------------------
	private String srchType;			// 검색유형
	private String srchVal;				// 검색값
	// ---------------------------
	
	// 산책루트 --------------------
	private String routeNo;				// 산책루트번호
	private String routeName;			// 루트이름
	private String routeDepartures;		// 루트출발지
	private String routeDestination;	// 루트도착지
	private String routePublic;			// 루트 공개여부(TRUE,FALSE)
	private int routeRatingCnt;			// 루트 평가 수
	private int routeRatingScoreAvg;	// 루트 평균 평점
	// ---------------------------
	
	// 페이징 ----------------------
	private int rowNum;					// 행번호
	private int totalCnt;				// 총건수
	private int pageCnt;				// 페이지 count
	private int pageIdx;				// 현재페이지 index
	private int startPageIdx;			// 시작페이지 index
	private int endPageIdx;				// 마지막페이지 index
	private int cntPerPage;				// 조회건수
	// ---------------------------
}
