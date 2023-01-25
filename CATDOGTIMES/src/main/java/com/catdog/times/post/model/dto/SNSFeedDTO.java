package com.catdog.times.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SNSFeedDTO {
	private int feedId; // 피드 id
	private String feedContent; // 피드 콘텐츠
	private String writerName;
	private String writerPhoto;
	private String feedImage;
	private String likerName;
	private String likerPhoto;
	private int postLikeCount; // 게시글 좋아요 개수
	private int replyCount; // 게시글당 댓글 개수
	private int memberNo;
}
