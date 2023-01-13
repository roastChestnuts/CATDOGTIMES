package com.catdog.times.post.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	private int postId;
	private String postContent;
	private Date postCreateDate;
	private Date postUpdateDate;
	private int memberNo;
}
