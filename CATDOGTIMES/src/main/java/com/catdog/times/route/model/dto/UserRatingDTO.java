package com.catdog.times.route.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingDTO {
	private int RatingUserNo;
	private int RatingTargetMemberNo;
	private int WalkRatingScore;
	private int memberNo;
}
