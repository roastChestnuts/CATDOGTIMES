package com.catdog.times.member.model.service;

public interface MailSendService {
	//난수생성 메소드
	public void makeRandomNumber();
	//이메일 내용 양식
	public String joinEmail(String email);
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content);
}
