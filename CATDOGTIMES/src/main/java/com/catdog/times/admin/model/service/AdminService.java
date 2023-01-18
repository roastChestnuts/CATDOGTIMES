package com.catdog.times.admin.model.service;

import java.util.List;

import com.catdog.times.admin.model.dto.AdminDTO;
import com.catdog.times.admin.model.dto.AdminStaticsDTO;

public interface AdminService {
	
	//대시보드 항목 별 Total 조회
	List<AdminStaticsDTO> selectAllTotalCount();
	
	//선택년도 01~12월 리스트 조회
	List<AdminStaticsDTO> selectMonthly(String nowYear);
	List<AdminStaticsDTO> selectMonthlyMember(String nowYear);
	List<AdminStaticsDTO> selectMonthlyRoute(String nowYear);
	List<AdminStaticsDTO> selectMonthlyParty(String nowYear);
	List<AdminStaticsDTO> selectMonthlyPost(String nowYear);
	
	//현재날짜 기준 최근7, 15일 데이터 리스트 조회
	List<AdminStaticsDTO> selectDaily(AdminStaticsDTO adminStaticsDTO);
	List<AdminStaticsDTO> selectDailyMember(AdminStaticsDTO adminStaticsDTO);
	List<AdminStaticsDTO> selectDailyRoute(AdminStaticsDTO adminStaticsDTO);
	List<AdminStaticsDTO> selectDailyParty(AdminStaticsDTO adminStaticsDTO);
	List<AdminStaticsDTO> selectDailyPost(AdminStaticsDTO adminStaticsDTO);

	//게시글 현황 리스트 조회
	List<AdminDTO> selectBoardList();
	
	//댓글 현황 리스트 조회
	List<AdminDTO> selectReplyList();
	
	//회원 정보 리스트 조회
	List<AdminDTO> selectMemberList(AdminDTO adminDTO);
	
	//회원 활성 여부 수정
	int updateMemberIs(AdminDTO adminDTO);
	
	//게시글 리스트 조회 - 관리자 전용
	List<AdminDTO> selectBoardManageList(AdminDTO adminDTO); 
	
	//회원 활성 여부 수정
	int updatePostShowYn(AdminDTO adminDTO);
	
	//게시글 리스트 조회 - 관리자 전용
	List<AdminDTO> selectRouteManageList(AdminDTO adminDTO);
	
	//산책 루트 공개 여부 수정
	int updateRoutePublic(AdminDTO adminDTO);
}
