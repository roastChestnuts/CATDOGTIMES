package com.catdog.times.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catdog.times.admin.model.dto.AdminDTO;
import com.catdog.times.admin.model.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin") 
public class AdminController {
	
	@Autowired
	private AdminService service; 
	
	@RequestMapping("/dashboard")
	public ModelAndView retrieveDashboardInfo(ModelAndView model) {
		//대시보드 - 게시글 조회
		List<AdminDTO> boardList = service.selectBoardList();
		model.addObject("boardList", boardList);
		//대시보드 - 댓글 조회
		List<AdminDTO> replyList = service.selectReplyList();	
		model.addObject("replyList", replyList);
		model.setViewName("adminMain"); 
		return model;
	}
	
	@RequestMapping(value= "/usermanage" , method=RequestMethod.GET)
	public ModelAndView retrieveUsermanageInfo(ModelAndView model, AdminDTO param) {
		// 사용자 관리 - 회원 정보 조회
		
		System.out.println("ajax 호출 adminDTO 값 ???  " + param);
		List<AdminDTO> memberList = service.selectMemberList();
		model.addObject("memberList" , memberList);
		model.setViewName("adminUserManage");
		return model;
	}
	
	@RequestMapping("/boardmanage")
	public ModelAndView retrieveBoardmanageInfo(ModelAndView model) {
		//
		List<AdminDTO> boardManageList = service.selectBoardManageList();
		model.addObject("boardManageList" , boardManageList);
		model.setViewName("adminBoardManage");
		return model;
	}
	
	@RequestMapping("/routemanage")
	public String retrieveRoutemanageInfo() {
		return "adminRouteManage";
	}

}
