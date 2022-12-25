package com.catdog.times.member.model.service;

import com.catdog.times.member.model.dto.Member;

public interface MemberService {

	Member findMemberById(String id); //아이디찾기
	
	Member login(String id, String password); // 로그인

	//int save(Member member); //회원가입

	//Boolean isDuplicateID(String id); //아이디중복체크

	//int delete(int no); //회원삭제
}
