package com.catdog.times.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.catdog.times.admin.model.dto.AdminDTO;

@Mapper
public interface AdminMapper {
	
	//게시글 현황 리스트 조회
	List<AdminDTO> selectBoardList();
	
	//댓글 현황 리스트 조회
	List<AdminDTO> selectReplyList();	
	
	//회원 정보 리스트 조회
	List<AdminDTO> selectMemberList(AdminDTO adminDTO);
	
	//회원활성 여부 수정
	int updateMemberIs(AdminDTO adminDTO);
	
	//게시글 리스트 조회 - 관리자 전용
	List<AdminDTO> selectBoardManageList();
	
}
