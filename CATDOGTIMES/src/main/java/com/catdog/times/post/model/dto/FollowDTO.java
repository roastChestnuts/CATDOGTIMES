package com.catdog.times.post.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowDTO {
	private int followId;
	private int followerId; // == 내멤버아이디값
	private int followingId; // == 팔로우하는 대상의 아이디값
}
