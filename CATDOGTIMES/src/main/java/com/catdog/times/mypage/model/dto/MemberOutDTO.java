package com.catdog.times.mypage.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberOutDTO {
	private int memberNo;
	private String outReasons;
	private Date outDate;
}
