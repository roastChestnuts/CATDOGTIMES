package com.catdog.times.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catdog.times.admin.model.dto.AdminDTO;
import com.catdog.times.admin.model.dto.AdminStaticsDTO;
import com.catdog.times.admin.model.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService { 	
	@Autowired
	private AdminMapper mapper;
	
	//대시보드 항목별 Total값 조회	
	@Override
	public List<AdminStaticsDTO> selectAllTotalCount() { 
		return mapper.selectAllTotalCount(); 
	}
	//선택년도 01~12월 리스트 조회
	@Override
	public List<AdminStaticsDTO> selectMonthly(String nowYear) { 
		return mapper.selectMontly(nowYear); 
	}
	@Override
	public List<AdminStaticsDTO> selectMonthlyMember(String nowYear) { 
		return mapper.selectMontlyMember(nowYear); 
	}
	@Override
	public List<AdminStaticsDTO> selectMonthlyRoute(String nowYear) { 
		return mapper.selectMontlyRoute(nowYear); 
	}
	@Override
	public List<AdminStaticsDTO> selectMonthlyParty(String nowYear) { 
		return mapper.selectMontlyParty(nowYear); 
	}
	@Override
	public List<AdminStaticsDTO> selectMonthlyPost(String nowYear) { 
		return mapper.selectMontlyPost(nowYear); 
	}
	
	@Override
	public List<AdminStaticsDTO> selectDaily(AdminStaticsDTO adminStaticsDTO) { 
		return mapper.selectDaily(adminStaticsDTO); 
	}
	@Override
	public List<AdminStaticsDTO> selectDailyMember(AdminStaticsDTO adminStaticsDTO) { 
		return mapper.selectDailyMember(adminStaticsDTO); 
	}
	@Override
	public List<AdminStaticsDTO> selectDailyRoute(AdminStaticsDTO adminStaticsDTO) { 
		return mapper.selectDailyRoute(adminStaticsDTO); 
	}
	@Override
	public List<AdminStaticsDTO> selectDailyParty(AdminStaticsDTO adminStaticsDTO) { 
		return mapper.selectDailyParty(adminStaticsDTO); 
	}
	@Override
	public List<AdminStaticsDTO> selectDailyPost(AdminStaticsDTO adminStaticsDTO) { 
		return mapper.selectDailyPost(adminStaticsDTO); 
	}
	
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
	
	//게시글 리스트 조회 - 관리자 전용
	@Override
	public List<AdminDTO> selectRouteManageList(AdminDTO adminDTO) { 
		return mapper.selectRouteManageList(adminDTO); 
	}
	
	@Override
	public int updateRoutePublic(AdminDTO adminDTO) { 
		return mapper.updateRoutePublic(adminDTO);  
	}
}
