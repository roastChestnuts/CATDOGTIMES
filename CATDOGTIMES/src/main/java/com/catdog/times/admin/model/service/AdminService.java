package com.catdog.times.admin.model.service;

import java.util.List;

import com.catdog.times.admin.model.dto.AdminDTO;

public interface AdminService {
	//게시글 현황 리스트 조회
	List<AdminDTO> selectBoardList();
	//댓글 현황 리스트 조회
	List<AdminDTO> selectReplyList();
	//회원 정보 리스트 조회
	List<AdminDTO> selectMemberList();
	//게시글 리스트 조회 - 관리자 전용
	List<AdminDTO> selectBoardManageList();
}
