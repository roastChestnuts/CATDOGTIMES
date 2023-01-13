package com.catdog.times.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
	private int imageId;
	private String imageSavedName;
	private String imageOriginalName;
	private int postId;
}
