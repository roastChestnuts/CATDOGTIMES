package com.catdog.times.mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.catdog.times.mypage.model.dto.FollowMemberDTO;
import com.catdog.times.mypage.model.dto.MemberOutDTO;
import com.catdog.times.mypage.model.dto.MyWalksDTO;
import com.catdog.times.mypage.model.dto.MypageDTO;
import com.catdog.times.mypage.model.dto.PostContentDTO;
import com.catdog.times.mypage.model.service.MypageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Controller
public class mypageController {
	private static final Logger logger = LoggerFactory.getLogger(mypageController.class);
	
	@Autowired
	FileUploadLogic fileuploadService;
	
	@Autowired
	private MypageService service;
	
	@RequestMapping(value = "/mypage")
//	public ModelAndView mypage(ModelAndView model, @RequestParam("memberId") String memberId) {
	public ModelAndView mypage(ModelAndView model, @RequestParam("id") String id) {	
		logger.info("jsp에서 요청오면, 마이페이지 스타트");
		//MypageDTO mypagedto = service.findByID("shin");		
		MypageDTO mypagedto = service.findByID(id);
		logger.info(mypagedto.toString());
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchType", "bookmark");
		map.put("memberNo", mypagedto.getMemberNo());
		
		List<PostContentDTO> postcontentList = service.selectPostContent(map);
		
		logger.info(postcontentList.toString());
		
		model.addObject("memberinfo", mypagedto );
		model.addObject("postcontentlist", postcontentList );
		
		model.setViewName("mypage/mypage");
		
		return model;
	}
	
	
	@RequestMapping(value = "/mypage/memberinfo", method = RequestMethod.GET)
//	public MypageDTO memberinfo(ModelAndView mdel, @RequestBody Map<String,Object> body) {	
	public MypageDTO memberinfo(String id) {	
		logger.info("리액트에서 요청오면, mypagedto 스타트" + id);
				
		
		MypageDTO mypagedto = service.findByID(id);
		logger.info(mypagedto.toString());
				
		return mypagedto;
	}
	
	@RequestMapping(value = "/mypage/postSearch", method = RequestMethod.POST)
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

	
	@RequestMapping(value = "/mypage/memberUpdate", method = RequestMethod.POST)
//	public MypageDTO memberinfoUpdate(@RequestBody MypageDTO mypage) throws IllegalStateException, IOException {		
	public MypageDTO memberinfoUpdate(@RequestPart("mypage") MypageDTO mypage, @RequestPart(required = false) MultipartFile photofile, HttpSession session) throws IllegalStateException, IOException {		
		//logger.info("리액트에서 정보 수정 요청오면, 회원정보 수정 스타트"+mypage.toString()+"-"+photofile.toString());
				
		String path = WebUtils.getRealPath(session.getServletContext(), "/resources/upload");
		logger.info("path ===== "+ path);
			
		if(photofile != null){
			String filename = fileuploadService.uploadFiles(photofile, path);			
			mypage.setMemberPhoto(filename);
		}
		
		service.updateMemberInfo(mypage);
		MypageDTO result = service.findByID(mypage.getMemberId());
		logger.info("정보수정 후 memberinfo 로 이동");
		return result;
	}
	
	@RequestMapping(value = "/mypage/followSearch", method = RequestMethod.POST)
	public List<FollowMemberDTO> memberFollowSearch(String type, String memberNo) {	
		logger.info("리액트에서 요청오면, memberFollowSearch-" + type+ "-" + memberNo );
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type", type);
		map.put("memberNo", memberNo);		
		
		List<FollowMemberDTO> followList = service.selectFollowList(map);		
		logger.info(followList.toString());
				
		return followList;
	}
	
	@RequestMapping(value = "/mypage/deleteFollower", method = RequestMethod.POST)
	public List<FollowMemberDTO> deleteFollower(String type, String memberNo, String followId) {	
		logger.info("리액트에서 요청오면, deleteFollower-" + memberNo + "-" + followId );
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type", type);
		map.put("memberNo", memberNo);		
		map.put("followId", followId);
		
		service.deleteFollower(map);		
		List<FollowMemberDTO> followList = service.selectFollowList(map);		
		logger.info(followList.toString());
				
		return followList;
		//return null;
	}
	
	
	@RequestMapping(value = "/mypage/delete/account", method = RequestMethod.POST)
	public String withdrawal(@RequestBody MemberOutDTO outinfo) {	
		logger.info("리액트에서 탈퇴 요청 - " + outinfo.getMemberNo() + " - " + outinfo.getOutReasons() );
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("memberNo", memberNo);
//		map.put("memberId", memberId);		
//		map.put("outReasons", outReasons);
		
		int re = service.withdrawal(outinfo);
		logger.info("리액트에서 탈퇴 요청 withdrawal - " + re);
				
		return "ok";
	}
	
	@RequestMapping(value = "/mypage/myWalks", method = RequestMethod.POST)
	public List<MyWalksDTO> myWalksSearch(String memberNo) {	
		logger.info("리액트에서 요청오면, memberNo-" +  memberNo );
		List<MyWalksDTO> mywalksdto = service.mywalks(memberNo);
		logger.info("리액트에서 요청오면, mymalksdto-" +  mywalksdto );
		return mywalksdto;
	}
	
	@RequestMapping(value = "/mypage/joinedWalks", method = RequestMethod.POST)
	public List<MyWalksDTO> joinedWalksSearch(String memberNo) {	
		logger.info("리액트에서 요청오면, memberNo-" +  memberNo );
		List<MyWalksDTO> jowalksdto = service.joinedwalks(memberNo);
		logger.info("리액트에서 요청오면, joinedwalks-" +  jowalksdto );
		return jowalksdto;
	}
	
}
