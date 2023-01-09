package com.catdog.times.member.model.service;

import com.catdog.times.member.model.dto.Member;

public interface MailSendService {
	//난수생성 메소드
	public void makeRandomNumber();
	//이메일 내용 양식
	public String joinEmail(String email);
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content);
	//임시 비밀번호 생성
	public String createTmpPassword(Member member, String pw);
	//임시 비밀번호 변경
	public int setTmpPassword(Member member, String pw);
	//임시 비밀번호 메일 전송
	public void sendTmpPwdEmail(String email, Member member, String tmpPw);
}
