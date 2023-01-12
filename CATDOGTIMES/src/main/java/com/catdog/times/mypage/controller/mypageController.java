package com.catdog.times.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;
import com.catdog.times.mypage.model.service.MypageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Controller
public class mypageController {
	private static final Logger logger = LoggerFactory.getLogger(mypageController.class);
	
	@Autowired
	private MypageService service;
	
//	@RequestMapping(value = "/mypage")
////	public ModelAndView mypage(ModelAndView model, @RequestParam("memberId") String memberId) {
//	public ModelAndView mypage(ModelAndView model, @RequestParam("id") String id) {	
//		logger.info("jsp에서 요청오면, 마이페이지 스타트");
//		//MypageDTO mypagedto = service.findByID("shin");		
//		MypageDTO mypagedto = service.findByID(id);
//		logger.info(mypagedto.toString());
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("searchType", "bookmark");
//		map.put("memberNo", mypagedto.getMemberNo());
//		
//		List<PostContentDTO> postcontentList = service.selectPostContent(map);
//		
//		logger.info(postcontentList.toString());
//		
//		model.addObject("memberinfo", mypagedto );
//		model.addObject("postcontentlist", postcontentList );
//		
//		model.setViewName("mypage/mypage");
//		
//		return model;
//	}
	
	
	@RequestMapping(value = "/memberinfo", method = RequestMethod.POST)
//	public MypageDTO memberinfo(ModelAndView mdel, @RequestBody Map<String,Object> body) {	
	public MypageDTO memberinfo(String id) {	
		logger.info("리액트에서 요청오면, mypagedto 스타트" + id);
		MypageDTO mypagedto = service.findByID(id);
		logger.info(mypagedto.toString());
				
		return mypagedto;
	}
	
	@RequestMapping(value = "/memberPostSearch", method = RequestMethod.POST)
	public List<PostContentDTO> memberPostSearch(String searchType, String memberNo) {	
	//public MypageDTO memberPostSearch(String id) {	
		logger.info("리액트에서 요청오면, memberPostSearch-" + searchType+ "-" + memberNo );
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchType", searchType);
		map.put("memberNo", memberNo);		
		
		List<PostContentDTO> postcontentList = service.selectPostContent(map);		
		logger.info(postcontentList.toString());
				
		return postcontentList;
	}

	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public MypageDTO memberinfo(ModelAndView mdel, @RequestBody Map<String,Object> body) {		
		logger.info("리액트에서 요청오면, 회원정보 스타트");				
		return null;
	}
	
	
}
