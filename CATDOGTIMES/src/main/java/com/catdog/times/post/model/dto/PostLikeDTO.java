package com.catdog.times.post.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostLikeDTO {
	private int postLikeId;
	private int postId;
	private int memberNo;
	private Date postLikeCreatedDate;
}
