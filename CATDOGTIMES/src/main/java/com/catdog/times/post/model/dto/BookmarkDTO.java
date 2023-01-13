package com.catdog.times.post.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDTO {
	private int bookmarkId;
	private int memberNo;
	private int postId;
	private Date bookmarkCreatedDate;
}
