package com.catdog.times.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catdog.times.admin.model.dto.AdminDTO;
import com.catdog.times.admin.model.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService { 
	
	@Autowired
	private AdminMapper mapper;
	//게시글 현황 리스트 조회	
	@Override
	public List<AdminDTO> selectBoardList() { 
		return mapper.selectBoardList(); 
	}
	//댓글 현황 리스트 조회
	@Override
	public List<AdminDTO> selectReplyList() { 
		return mapper.selectReplyList();
	}
	
	//회원 정보 리스트 조회
	@Override
	public List<AdminDTO> selectMemberList() { 
		return mapper.selectMemberList();
	}
	
	
}
