package com.catdog.times.route.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalkRouteDTO {
	private int routeNo;
	private String routeName;
	private String routeThumbnail;
	private String routeDepartures;
	private String routeDestination;
	private String routeLocations;
	private String routePublic;
	private Date routeCreateDate;
	private int memberNo;
	
}
