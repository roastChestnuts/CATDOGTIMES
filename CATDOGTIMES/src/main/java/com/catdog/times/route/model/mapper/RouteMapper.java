package com.catdog.times.route.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.PostLikeDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.route.model.dto.RouteRatingDTO;
import com.catdog.times.route.model.dto.UserRatingDTO;
import com.catdog.times.route.model.dto.WalkMyRouteDTO;
import com.catdog.times.route.model.dto.WalkParticipantDTO;
import com.catdog.times.route.model.dto.WalkPartyDTO;
import com.catdog.times.route.model.dto.WalkRouteDTO;

@Mapper
public interface RouteMapper {
	/* <<<CREATE>>> */
	// 루트 등록
	int insertWalkRoute(WalkRouteDTO route);
	// 산책 파티 등록
	int insertWalkParty(WalkPartyDTO party);
		
	// 마이루트 등록
	int insertWalkMyRoute(WalkMyRouteDTO myRoute);

	// 파티 참여자 등록
	int insertWalkParticipant(WalkParticipantDTO participant);
	
	// 루트 평점 등록
	int insertRouteRating(RouteRatingDTO userRating);

	// 루트 사용자 평점 등록
	int insertUserRating(UserRatingDTO post);

	/* <<<LIST, READ>>> */
	// 전체 루트 기록 조회
	List<WalkRouteDTO> getRouteList(int memberNo);	
	
	// 마이 루트 조회
	List<WalkMyRouteDTO> getMyRouteList(int memberNo);	
	
	// 특정 루트 조회 
	WalkRouteDTO getRoute(int routeNo);
	
	// 특정 마이루트 조회 
	WalkMyRouteDTO getMyRoute(int routeNo);
	
	// 특정 루트 평점 조회
	RouteRatingDTO getRouteRating(int routeRatingNo);

	// 사용자 평점 조회
	UserRatingDTO getRatingUser(int userRatingNo);

	// 파티 정보 조회
	WalkPartyDTO getWalkParty(int partyNo);

	// 파티 참가자 조회
	List<WalkParticipantDTO> getPartyParticipant(int walkParticipantNo);	


	/* <<<DELETE>>> */
	
	// 루트 삭제
	int deleteRoute(int routeNo);
	
	// 마이루트 삭제
	int deleteMyRoute(int myRouteNo);
	
	// 파티 참여자 삭제
	int deleteWalkParticipant(int walkParticipantNo);
	

	
}