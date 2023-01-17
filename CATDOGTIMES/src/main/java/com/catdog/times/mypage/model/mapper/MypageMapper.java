package com.catdog.times.mypage.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.catdog.times.mypage.model.dto.FollowMemberDTO;
import com.catdog.times.mypage.model.dto.MemberOutDTO;
import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;

@Mapper
public interface MypageMapper {
	MypageDTO findByID(String memberId);	
	List<PostContentDTO> selectPostContent(Map<String,Object> map);
	int updateMemberInfo(MypageDTO mypagedto);
	List<FollowMemberDTO> selectFollowList(Map<String,Object> map);
	int deleteFollower(Map<String,Object> map);
	int withdrawal(MemberOutDTO outinfo);
	int memberout(MemberOutDTO outinfo);
}
