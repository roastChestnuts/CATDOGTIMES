package com.catdog.times.route.model.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.catdog.times.route.model.dto.RouteRatingDTO;
import com.catdog.times.route.model.dto.UserRatingDTO;
import com.catdog.times.route.model.dto.WalkMyRouteDTO;
import com.catdog.times.route.model.dto.WalkParticipantDTO;
import com.catdog.times.route.model.dto.WalkPartyDTO;
import com.catdog.times.route.model.dto.WalkRouteDTO;

public interface RouteService {
	/* <<<CREATE>>> */
	// Route Create
	int insertWalkRoute(WalkRouteDTO route, @RequestPart(required=false) MultipartFile file,HttpSession session) throws IllegalStateException, IOException;

	// MyRoute Create
	int insertWalkMyRoute(WalkMyRouteDTO route, @RequestPart(required=false) MultipartFile file,HttpSession session) throws IllegalStateException, IOException;

	// Walk Party Create
	int insertWalkParty(WalkPartyDTO party);

	// Party Participant Create
	int insertWalkParticipant(WalkParticipantDTO participant);

	// Route Rating create
	int insertRouteRating(RouteRatingDTO userRating);

	// User rating create
	int insertUserRating(UserRatingDTO userRating);

	
	/* <<<LIST, READ>>> */
	// 전체 루트 기록 조회
	List<WalkRouteDTO> getRouteList(int memberNo);	
	
	// 마이 루트 조회
	List<WalkMyRouteDTO> getMyRouteList(int memberNo);	
	
	// 특정 루트 조회 
	WalkRouteDTO getRoute(int routeNo);
	
	// 특정 마이루트 조회 
	WalkMyRouteDTO getMyRoute(int myRouteNo);
	
	// 특정 루트 평점 조회
	RouteRatingDTO getRouteRating(int routeRatingNo);

	// 사용자 평점 조회
	UserRatingDTO getUserRating(int memberNo);

	// 파티 정보 조회
	WalkPartyDTO getWalkParty(int partyNo);

	// 파티 참가자 조회
	List<WalkParticipantDTO> getPartyParticipant(int partyNo);	


	/* <<<DELETE>>> */
	
	// 루트 삭제
	int deleteRoute(int routeNo);
	
	// 마이루트 삭제
	int deleteMyRoute(int myRouteNo);
	
	// 파티 참여자 삭제
	int deleteWalkParticipant(int walkParticipantNo);
	

	
}