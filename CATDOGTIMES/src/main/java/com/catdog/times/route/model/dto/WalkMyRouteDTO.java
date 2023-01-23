package com.catdog.times.route.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalkMyRouteDTO {
	private int myRouteNo;
	private String myRouteName;
	private String myRouteThumbnail;
	private String myRouteDepartures;
	private String myRouteDestination;
	private String myRouteLocations;
	private Date myRouteCreateDate;
	private int memberNo;
}
