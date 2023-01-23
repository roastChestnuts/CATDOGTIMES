package com.catdog.times.member.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int no;
	
	private String id;
	
	private String password;
	
	private String name;
	
	private String gender;
	
	private String nickName;
	
	private String email;
	
	private String is; //
	
	private String photo;
	
	private int type;
	
	private int warn; //
	
	private Date createDate; //
	
	private Date modifyDate; //

	private String address;
	
	private String zipcode;
	
	private String detailAddress;
	
	private String snsId;
	
	private String animalRegNo;
}
