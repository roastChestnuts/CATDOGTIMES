package com.catdog.times.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
	private int memberNo;
	private int postId;
	private String memberId; 
	private String memberName;
	private String memberNickName;
	private String memberPhoto;
}
