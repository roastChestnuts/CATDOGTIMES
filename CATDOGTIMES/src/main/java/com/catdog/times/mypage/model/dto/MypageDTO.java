package com.catdog.times.mypage.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MypageDTO {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String memberNickname;
	private String memberEmail;
	private String memberIs;
	private int memberType;
	private int memberWarn;
	private Date memberCreateDate;
	private Date modifyDate;
	private String memberPhoto;
	private String memberAddress;
	private String memberZipcode;
	private String memberDetailAddress;
	private String memberSnsId;
    
	private int postTotal;
	private int followerCnt;
	private int followingCnt;
	
	private String animalRegNo;
}
