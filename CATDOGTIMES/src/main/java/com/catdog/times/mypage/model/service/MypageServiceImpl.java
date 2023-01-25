package com.catdog.times.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catdog.times.mypage.model.dto.FollowMemberDTO;
import com.catdog.times.mypage.model.dto.MemberOutDTO;
import com.catdog.times.mypage.model.dto.MyWalksDTO;
import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;
import com.catdog.times.mypage.model.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MypageMapper mapper;
	
	@Override
	public MypageDTO findByID(String memberNo) {
		return mapper.findByID(memberNo);
	}
	
	@Override
	public List<PostContentDTO> selectPostContent(Map<String,Object> map) {
		return mapper.selectPostContent(map);
	}

	@Override
	public int updateMemberInfo(MypageDTO mypagedto) {
		
		mypagedto.setMemberPw(passwordEncoder.encode(mypagedto.getMemberPw()));		
		return mapper.updateMemberInfo(mypagedto);
	}
	
	@Override
	public List<FollowMemberDTO> selectFollowList(Map<String,Object> map) {
		return mapper.selectFollowList(map);
	}
	
	@Override
	public int deleteFollower(Map<String,Object> map) {
		return mapper.deleteFollower(map);
	}
	
	@Override
	@Transactional
	public int withdrawal(MemberOutDTO outinfo) {
		mapper.withdrawal(outinfo);
		mapper.memberout(outinfo);
		return 0;
	}

	@Override
	public List<MyWalksDTO> mywalks(String memberNo) {
		return mapper.mywalks(memberNo);
	}
	@Override
	public List<MyWalksDTO> joinedwalks(String memberNo) {
		return mapper.joinedwalks(memberNo);
	}
	
}
