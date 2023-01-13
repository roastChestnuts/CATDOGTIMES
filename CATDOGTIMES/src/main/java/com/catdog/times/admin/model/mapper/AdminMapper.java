package com.catdog.times.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.catdog.times.admin.model.dto.AdminDTO;
import com.catdog.times.admin.model.dto.AdminStaticsDTO;

@Mapper
public interface AdminMapper {
	
	//대시보드 Total 조회
	List<AdminStaticsDTO> selectAllTotalCount();
	
	//게시글 현황 리스트 조회
	List<AdminDTO> selectBoardList();
	
	//댓글 현황 리스트 조회
	List<AdminDTO> selectReplyList();	
	
	//회원 정보 리스트 조회
	List<AdminDTO> selectMemberList(AdminDTO adminDTO);
	
	//회원활성 여부 수정
	int updateMemberIs(AdminDTO adminDTO);
	
	//게시글 리스트 조회 - 관리자 전용
	List<AdminDTO> selectBoardManageList(AdminDTO adminDTO);
	
	//피드 노출 여부 수정
	int updatePostShowYn(AdminDTO adminDTO);
	
	//산책루트 리스트 조회 - 관리자 전용
	List<AdminDTO> selectRouteManageList(AdminDTO adminDTO);
	
	//산책루트 공개 여부 수정
	int updateRoutePublic(AdminDTO adminDTO);
}
