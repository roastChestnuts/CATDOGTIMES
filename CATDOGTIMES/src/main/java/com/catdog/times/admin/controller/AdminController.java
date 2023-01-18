package com.catdog.times.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.catdog.times.admin.model.dto.AdminDTO;
import com.catdog.times.admin.model.dto.AdminStaticsDTO;
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
			//대시보드 - 항목별 Total값 조회
			List<AdminStaticsDTO> totalList = service.selectAllTotalCount();	
			//대시보드 - 게시글 조회
			List<AdminDTO> boardList = service.selectBoardList();
			//대시보드 - 댓글 조회
			List<AdminDTO> replyList = service.selectReplyList();	
			
			model.addObject("totalList", totalList);
			model.addObject("boardList", boardList);
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
		
		@RequestMapping("/dashboard/monthly")
		@ResponseBody
		public int[][] retrieveMonthlyTotalCount(String nowYear) {
			List<AdminStaticsDTO> monthly = service.selectMonthly(nowYear);
			List<AdminStaticsDTO> montlyMember= service.selectMonthlyMember(nowYear);
			List<AdminStaticsDTO> montlyRoute= service.selectMonthlyRoute(nowYear);
			List<AdminStaticsDTO> montlyParty= service.selectMonthlyParty(nowYear);
			List<AdminStaticsDTO> montlyPost = service.selectMonthlyPost(nowYear);
			int[][] result = new int[12][5];
			for(int i = 0 ; i < result.length; i++) {
				for(int j = 0 ; j < result[i].length ; j ++) {
					 {
						if(j==0){
							result[i][j] = Integer.parseInt(monthly.get(i).getMonthly());
						} else if(j==1){
							result[i][j] = montlyMember.get(i).getTotalCnt();
						} else if(j==2){
							result[i][j] = montlyRoute.get(i).getTotalCnt();
						} else if(j==3){
							result[i][j] = montlyParty.get(i).getTotalCnt();
						} else if(j==4){
							result[i][j] = montlyPost.get(i).getTotalCnt();
						}
					}
				}
			}
			return result;
		}
		
		
		@RequestMapping("/dashboard/daily")
		@ResponseBody
		public int[][] retrieveDailyTotalCount(AdminStaticsDTO adminStaticsDTO) {
			List<AdminStaticsDTO> daily = service.selectDaily(adminStaticsDTO);
			List<AdminStaticsDTO> dailyMember= service.selectDailyMember(adminStaticsDTO);
			List<AdminStaticsDTO> dailyRoute= service.selectDailyRoute(adminStaticsDTO);
			List<AdminStaticsDTO> dailyParty= service.selectDailyParty(adminStaticsDTO);
			List<AdminStaticsDTO> dailyPost = service.selectDailyPost(adminStaticsDTO);
			int ck = adminStaticsDTO.getPeriodVal();
			int[][] result = new int[ck][5];
			for(int i = 0 ; i < result.length; i++) {
				for(int j = 0 ; j < result[i].length ; j ++) {
					{
						if(j==0){
							result[i][j] = Integer.parseInt(daily.get(i).getDaily());
						} else if(j==1){
							result[i][j] = dailyMember.get(i).getTotalCnt();
						} else if(j==2){
							result[i][j] = dailyRoute.get(i).getTotalCnt();
						} else if(j==3){
							result[i][j] = dailyParty.get(i).getTotalCnt();
						} else if(j==4){
							result[i][j] = dailyPost.get(i).getTotalCnt();
						}
					}
				}
			}
			return result;
		}
		
		@RequestMapping("/boardmanage")
		public ModelAndView retrieveBoardmanageInfo(ModelAndView model) {
			// 게시글 관리
			//List<AdminDTO> boardManageList = service.selectBoardManageList();
			//model.addObject("boardManageList" , boardManageList);
			model.setViewName("admin/adminBoardManage");
			return model;
	 	}
		
		@RequestMapping("/routemanage")
		public String retrieveRoutemanageInfo() {
			return "admin/adminRouteManage";
		}
		
		// 사용자 목록 조회
		@RequestMapping("/usermanage/memberlist")
		@ResponseBody
		public List<AdminDTO> retrieveMemberList(AdminDTO adminDTO) {
			log.info("admin DTO :::: " + adminDTO.toString());
			List<AdminDTO> memberList = service.selectMemberList(adminDTO);
			return memberList;
		}
		
		// 사용자 활성/비활성 처리
		@RequestMapping("/usermanage/memberis")
		@ResponseBody
		public String updateMemberIs(@RequestBody AdminDTO adminDTO) {
			String result = "";
			log.info("updateMemberIs adminDTO ::: " + adminDTO.toString());
			int cnt = service.updateMemberIs(adminDTO);
			if(cnt == 0) {
				result = "fail";
			} else {
				result = "success";
			}
			return result; 
		}
		
		// 게시글 목록 조회
		@RequestMapping("/boardmanage/boardlist")
		@ResponseBody
		public List<AdminDTO> retrieveBoardList(AdminDTO adminDTO) {
			log.info("retrieveBoardList admin DTO :::: " + adminDTO.toString()); 
			List<AdminDTO> boardList = service.selectBoardManageList(adminDTO);
			return boardList;
		}
		
		// 피드 노출/미노출 처리
		@RequestMapping("/boardmanage/post")
		@ResponseBody
		public String updatePostShowYn(@RequestBody AdminDTO adminDTO) {
			String result = "";
			log.info("updatePostShowYn adminDTO ::: " + adminDTO.toString());
			int cnt = service.updatePostShowYn(adminDTO);
			if(cnt == 0) {
				result = "fail";
			} else {
				result = "success";
			}
			return result; 
		}
		
		// 산책루트 목록 조회
		@RequestMapping("/routemanage/routelist")
		@ResponseBody
		public List<AdminDTO> retrieveRouteManageList(AdminDTO adminDTO) {
			log.info("retrieveRouteManageList admin DTO :::: " + adminDTO.toString()); 
			List<AdminDTO> routeList = service.selectRouteManageList(adminDTO);
			return routeList;
		}
		
		// 산책루트 공개/비공개 처리
		@RequestMapping("/routemanage/route")
		@ResponseBody
		public String updateRoutePublic(@RequestBody AdminDTO adminDTO) {
			String result = "";
			log.info("updateRoutePublic adminDTO ::: " + adminDTO.toString());
			int cnt = service.updateRoutePublic(adminDTO);
			if(cnt == 0) {
				result = "fail";
			} else {
				result = "success";
			}
			return result; 
		}
		
	}
