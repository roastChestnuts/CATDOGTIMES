package com.catdog.times.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catdog.times.member.model.dto.Member;
import com.catdog.times.member.model.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member findMemberById(String id) {
		return mapper.selectMemberById(id);
	}
	
	@Override
	public Member login(String id, String password) {
		Member member = null;
		System.out.println(id);
		System.out.println(password);
		member = this.findMemberById(id);
		
		System.out.println(member);
		//if(member != null && passwordEncoder.matches(password, member.getPassword())) {
		if(member != null && password.equals(member.getPassword())) {
			return member;
		} else {
			return null;
		}
	}

	

}
