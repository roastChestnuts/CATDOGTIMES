package com.catdog.times.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class jwtUser {
	private String id;
	private String name;
	private int memberType;
}
