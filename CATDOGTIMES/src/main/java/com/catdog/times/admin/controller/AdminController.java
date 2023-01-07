package com.catdog.times.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
			model.setViewName("admin/adminMain");
			return model;
		}
		
		@RequestMapping("/usermanage")
		public ModelAndView retrieveUsermanageInfo(ModelAndView model, AdminDTO adminDTO) {
			// 사용자 관리 - 회원 정보 조회
			//List<AdminDTO> memberList = service.selectMemberList(adminDTO);
			//model.addObject("memberList" , memberList);
			model.setViewName("admin/adminUserManage");
			return model;
		}
		
		@RequestMapping("/boardmanage")
		public ModelAndView retrieveBoardmanageInfo(ModelAndView model) {
			// 게시글 관리
			List<AdminDTO> boardManageList = service.selectBoardManageList();
			model.addObject("boardManageList" , boardManageList);
			model.setViewName("admin/adminBoardManage");
			return model;
	 	}
		
		@RequestMapping("/routemanage")
		public String retrieveRoutemanageInfo() {
			return "admin/adminRouteManage";
		}
		
		@RequestMapping("/memberlist")
		@ResponseBody
		public List<AdminDTO> retrieveMemberList(AdminDTO adminDTO) {
			log.info("admin DTO :::: " + adminDTO.toString());
			List<AdminDTO> memberList = service.selectMemberList(adminDTO);
			return memberList;
		}
		
		@RequestMapping("/test")
		@ResponseBody
		public String updateMemberIs(@RequestBody AdminDTO adminDTO) {
			String result = "ok";
			log.info("updateMemberIs adminDTO ::: " + adminDTO.toString());
			int cnt = service.updateMemberIs(adminDTO);
			if(cnt == 0) {
				result = "fail";
			} else {
				result = "success";
			}
			return result; 
		}
	}
