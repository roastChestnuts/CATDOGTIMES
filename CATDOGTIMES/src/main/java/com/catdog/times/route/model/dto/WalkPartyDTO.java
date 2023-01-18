package com.catdog.times.route.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalkPartyDTO {
	private int partyNo;
	private String partyName;
	private String partyThumbnail;
	private String partyCategory;
	private String partyDepartures;
	private String partyDestination;
	private Date partyCreateDate;
	private Date partyDepartureDate;
	private int mamberNo;
	private int routeNo;
}
