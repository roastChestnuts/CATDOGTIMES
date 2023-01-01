package com.catdog.times.member.model.service;

import com.catdog.times.member.model.dto.Member;

public interface MemberService {

	Member findMemberById(String id); //아이디찾기
	
	Member login(String id, String password); // 로그인

	int save(Member member); //회원가입

	public int idCheck(String id);// 아이디 중복체크

	public int nickNameCheck(String nickName);// 닉네임 중복체크
	
	void kakaoJoin(Member member);
	
	Member kakaoLogin(String memberSnsId);
	
	String findMemberBySnsId(String memberSnsId);
	
	//int delete(int no); //회원삭제
}
