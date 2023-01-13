package com.catdog.times.post.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
	private int replyId;
	private String replyContent;
	private Date replyCreatedDate;
	private Date replyUpdateDate;
	private int postId;
	private int memberNo;
}
