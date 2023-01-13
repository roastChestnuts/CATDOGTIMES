package com.catdog.times.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostHashtagDTO {
	private int postHashtagId;
	private int postId;
	private String postHashtag;
}
