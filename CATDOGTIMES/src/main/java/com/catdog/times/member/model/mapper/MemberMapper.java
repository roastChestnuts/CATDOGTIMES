package com.catdog.times.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.catdog.times.member.model.dto.Member;


@Mapper
public interface MemberMapper {
	Member selectMemberById(@Param("id") String id);

}