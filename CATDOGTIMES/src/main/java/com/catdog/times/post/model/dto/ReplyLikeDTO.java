package com.catdog.times.post.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyLikeDTO {
	private int replyLikeId;
	private int replyId;
	private int memberNo;
	private Date replyLikeCreatedDate;
}
