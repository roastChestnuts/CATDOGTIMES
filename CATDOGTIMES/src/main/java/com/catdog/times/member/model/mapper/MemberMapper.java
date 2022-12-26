package com.catdog.times.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.catdog.times.member.model.dto.Member;


@Mapper
public interface MemberMapper {
	Member selectMemberById(@Param("id") String id);

	int insertMember(Member member);
	// 아이디 중복체크
	public int idCheck(String id);
}