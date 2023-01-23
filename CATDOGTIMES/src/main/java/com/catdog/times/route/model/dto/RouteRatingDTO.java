package com.catdog.times.route.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRatingDTO {
	private int routeRatingNo;
	private int routeNo;
	private int routeRatingScore;
	private int memberNo;
}
