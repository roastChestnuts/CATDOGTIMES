package com.catdog.times.route.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catdog.times.route.model.dto.RouteRatingDTO;
import com.catdog.times.route.model.dto.UserRatingDTO;
import com.catdog.times.route.model.dto.WalkMyRouteDTO;
import com.catdog.times.route.model.dto.WalkParticipantDTO;
import com.catdog.times.route.model.dto.WalkPartyDTO;
import com.catdog.times.route.model.dto.WalkRouteDTO;
import com.catdog.times.route.model.service.RouteService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/route")
@Slf4j
public class RouteController {
	@Autowired
	private RouteService service;

	/* Route 등록 */
	// Route 들록
	@RequestMapping(value = "/addroute", method = RequestMethod.POST)
	public String insertWalkRoute(@RequestPart("route") WalkRouteDTO route, @RequestPart(required=false) MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		System.out.println("route which come from front:"+route);
		System.out.println("컨트롤러:"+ file);
		int result = service.insertWalkRoute(route, file, session);	
		System.out.println("=====Route Create========");
		System.out.println("Route 결과값:" + result);		
		return "성공";
	}
	
	// myRoute 들록
	@RequestMapping(value = "/addmyroute", method = RequestMethod.POST)
	public String insertWalkMyRoute(@RequestPart("r") WalkMyRouteDTO route, @RequestPart(required=false) MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		System.out.println(route);
		System.out.println("컨트롤러:"+ file);
		int result = service.insertWalkMyRoute(route, file, session);	
		System.out.println("=====Route Create========");
		System.out.println("Route 결과값:" + result);		
		return "성공";
	}
	
	/* 산책파티 등록 */
	// Walk Party 등록
	@RequestMapping(value = "/addparty", method = RequestMethod.POST)
	public String insertWalkParty(WalkPartyDTO party) {
		System.out.println(party);
		int result = service.insertWalkParty(party);
		System.out.println("잘들어오나 확인:" + result);
		return "산책파티등록됨";
	}

	// Party Participant 등록
	@RequestMapping(value = "/addparticipant", method = RequestMethod.POST)
	public String insertWalkParticipant(WalkParticipantDTO participant) {
		System.out.println(participant);
		int result = service.insertWalkParticipant(participant);
		System.out.println("잘들어오나 확인:" + result);
		return "산책참가됨";
	}
	
	
	/* 평점 등록 */
	// Route Rating 등록
	@RequestMapping(value = "/addrouterating", method = RequestMethod.POST)
	public String insertRouteRating(@RequestPart("rate") RouteRatingDTO rate)throws IllegalStateException, IOException {
		System.out.println("routeRating from front:"+rate);
		int result = service.insertRouteRating(rate);
		System.out.println("잘들어오나 확인:" + result);
		return "루트 평점 등록됨";
	}
	
	// User Rating 등록
	@RequestMapping(value = "/adduserrating", method = RequestMethod.POST)
	public String insertUserRating(UserRatingDTO userRating){
		System.out.println(userRating);
		int result = service.insertUserRating(userRating);
		System.out.println("잘들어오나 확인:" + result);
		return "루트 평점 등록됨";
	}

	/* 루트 조회 */
	
	// 루트리스트 조회
	@GetMapping("/routelist")
	public List<WalkRouteDTO> getRouteList(@RequestParam int MemberNo, HttpServletRequest request) {
		String memberNo = (String)request.getAttribute("MemberNo");
		log.info(memberNo, MemberNo);
		 List<WalkRouteDTO> result = new ArrayList<>();
		if(MemberNo >= 0) {
			result = service.getRouteList(MemberNo); //파라미터 아이디로 조회
			System.out.println(result);
		}
		return result;
	}
	
	// 마이루트리스트 조회
	@GetMapping("/myRoutelist")
	public List<WalkMyRouteDTO> getMyRouteList(@RequestBody int MemberNo, HttpServletRequest request) {
		String memberNo = (String)request.getAttribute("MemberNo");
		log.info(memberNo, MemberNo);
		 List<WalkMyRouteDTO> result = new ArrayList<>();
		if(MemberNo >= 0) {
			result = service.getMyRouteList(MemberNo); //파라미터 아이디로 조회
		}
		return result;
	}
	
	// 특정 루트조회

	@GetMapping("/route")
		public WalkRouteDTO getRoute(@RequestParam int MemberNo, String RouteName, HttpServletRequest request) {	
		String memberNo = (String) request.getAttribute("MamberNo");
		String routeName = (String)request.getAttribute("RouteName");
		log.info(memberNo, MemberNo);
		log.info(routeName, RouteName);
		WalkRouteDTO walkRoutedto = service.getRoute(MemberNo);	
		return walkRoutedto;
	}
	
	// 특정 마이루트조회
	@RequestMapping(value = "/getMyRoute", method = RequestMethod.GET)
		public WalkMyRouteDTO getMyRoute(int myRouteNo) {	
				
		WalkMyRouteDTO walkMyRoutedto = service.getMyRoute(myRouteNo);	
		return walkMyRoutedto;
	}
	
	// 특정 루트 평점조회
	@RequestMapping(value = "/getRouteRating", method = RequestMethod.GET)
		public RouteRatingDTO getRouteRating(int routeRatingNo) {	
				
		RouteRatingDTO routeRatingdto = service.getRouteRating(routeRatingNo);	
		return routeRatingdto;
	}
	
	// 특정 사용자 평점조회
	@RequestMapping(value = "/getUserRating", method = RequestMethod.GET)
		public UserRatingDTO getUserRating(int memberNo) {	
				
		UserRatingDTO userRatingdto = service.getUserRating(memberNo);	
		return userRatingdto;
	}
	
	// 특정 파티조회
	@RequestMapping(value = "/getWalkParty", method = RequestMethod.GET)
		public WalkPartyDTO getWalkParty(int partyNo) {	
				
		WalkPartyDTO walkPartydto = service.getWalkParty(partyNo);	
		return walkPartydto;
	}
	
	// 특정 파티 참가자 리스트 조회
	@RequestMapping(value = "/getWalkParticipant", method = RequestMethod.GET)
		public List<WalkParticipantDTO> getPartyParticipant(int partyNo) {	
				
		List<WalkParticipantDTO> walkParticipantdto = service.getPartyParticipant(partyNo);	
		return walkParticipantdto;
	}
	

}