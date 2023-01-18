package com.catdog.times.post.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchMemberDTO {
	private int no;
	
	private String id;
	
	private String name;
	
	private String nickName;
	
	private String photo;
	
}
