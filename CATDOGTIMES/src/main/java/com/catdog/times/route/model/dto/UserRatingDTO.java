package com.catdog.times.route.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingDTO {
	private int userRatingNo;
	private int ratingTargetMemberNo;
	private int userRatingScore;
	private int memberNo;
}
