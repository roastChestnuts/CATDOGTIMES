package com.catdog.times.mypage.model.service;

import java.util.List;
import java.util.Map;

import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;

public interface MypageService {
	MypageDTO findByID(String memberId);
	List<PostContentDTO> selectPostContent(Map<String,Object> map);
}
