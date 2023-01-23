package com.catdog.times.mypage.model.service;

import java.util.List;
import java.util.Map;

import com.catdog.times.mypage.model.dto.FollowMemberDTO;
import com.catdog.times.mypage.model.dto.MemberOutDTO;
import com.catdog.times.mypage.model.dto.MyWalksDTO;
import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;

public interface MypageService {
	MypageDTO findByID(String memberId);
	List<PostContentDTO> selectPostContent(Map<String,Object> map);
	int updateMemberInfo(MypageDTO mypagedto);
	List<FollowMemberDTO> selectFollowList(Map<String,Object> map);
	int deleteFollower(Map<String,Object> map);
	int withdrawal(MemberOutDTO outinfo);
	
	List<MyWalksDTO> mywalks(String memberNo);
	List<MyWalksDTO> joinedwalks(String memberNo);
}
