package com.catdog.times.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class AdminStaticsDTO {
	
	private String totalMemberCnt;		// 가입자 수
	private String totalRouteCnt;		// 등록된 산책경로 수
	private String totalPartyCnt;		// 산책 매칭 수
	private String totalPostCnt;		// 피드 수
									// 산책루트 평균 평점
}
