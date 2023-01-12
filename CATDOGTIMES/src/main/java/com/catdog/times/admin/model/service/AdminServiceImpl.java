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
	public List<AdminDTO> selectMemberList(AdminDTO adminDTO) { 
		return mapper.selectMemberList(adminDTO);
	}
	//게시글 리스트 조회 - 관리자 전용
	@Override
	public List<AdminDTO> selectBoardManageList(AdminDTO adminDTO) { 
		return mapper.selectBoardManageList(adminDTO); 
	}
	
	@Override
	public int updateMemberIs(AdminDTO adminDTO) { 
		return mapper.updateMemberIs(adminDTO);  
	}
	
	@Override
	public int updatePostShowYn(AdminDTO adminDTO) { 
		return mapper.updatePostShowYn(adminDTO);  
	}
}
