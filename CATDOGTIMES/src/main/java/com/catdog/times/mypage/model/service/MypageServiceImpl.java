package com.catdog.times.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;
import com.catdog.times.mypage.model.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	private MypageMapper mapper;
	
	@Override
	public MypageDTO findByID(String memberId) {
		return mapper.findByID(memberId);
	}
	
	@Override
	public List<PostContentDTO> selectPostContent(Map<String,Object> map) {
		return mapper.selectPostContent(map);
	}
	

}
