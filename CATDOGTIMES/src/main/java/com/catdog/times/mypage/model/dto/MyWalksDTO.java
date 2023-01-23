package com.catdog.times.mypage.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MyWalksDTO {

	private int memberNo;
	private int routeNo;
	private String routeName;
	private String routeThumbnail;
	private String routeDepartures;
	private String routeDestination;
	private String routePublic;
	private String partyMemberNickname;
	private String partyName;
	private String partyThumbnail;
	private String partyCategory;
	private String partyDepartures;
	private String partyDestination;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date partyCreatedate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date partyDeparturedate;
	
}
