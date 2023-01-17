package com.catdog.times.mypage.model.dto;

import lombok.Data;

@Data
public class FollowMemberDTO {

	private int followId;
	private int memberNo;
	private String memberId;
	private String memberName;
	private String memberNickname;
	private String memberPhoto;	
	private String type;
}
