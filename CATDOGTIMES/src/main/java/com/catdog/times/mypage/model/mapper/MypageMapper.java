package com.catdog.times.mypage.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;

@Mapper
public interface MypageMapper {
	MypageDTO findByID(String memberId);	
	List<PostContentDTO> selectPostContent(Map<String,Object> map);
}
