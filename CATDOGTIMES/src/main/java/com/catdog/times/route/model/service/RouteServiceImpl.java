package com.catdog.times.route.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.catdog.times.route.model.dto.RouteRatingDTO;
import com.catdog.times.route.model.dto.UserRatingDTO;
import com.catdog.times.route.model.dto.WalkMyRouteDTO;
import com.catdog.times.route.model.dto.WalkParticipantDTO;
import com.catdog.times.route.model.dto.WalkPartyDTO;
import com.catdog.times.route.model.dto.WalkRouteDTO;
import com.catdog.times.route.model.mapper.RouteMapper;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RouteMapper mapper;
	
	/* <<<CREATE>>> */
	// Route Create
	
	@Override
	public int insertWalkRoute(WalkRouteDTO route, @RequestPart(required=false) MultipartFile file,HttpSession session) throws IllegalStateException, IOException
	{		
		String ImageSavedName = route.getRouteThumbnail();
		
		String path = WebUtils.getRealPath(session.getServletContext(), "/resources/upload");
		if(!file.isEmpty()) {
			file.transferTo(new File(path+File.separator+ImageSavedName));
		}
		
		return mapper.insertWalkRoute(route);
	}
	// Route Party Create
	@Override
	public int insertWalkParty(WalkPartyDTO party){		
		return mapper.insertWalkParty(party);
	};

	// MyRoute Create
	@Override
	public int insertWalkMyRoute(WalkMyRouteDTO myRoute, @RequestPart(required=false) MultipartFile file,HttpSession session) throws IllegalStateException, IOException
	{		
		return mapper.insertWalkMyRoute(myRoute);
	};

	// Party Participant Create
	@Override
	public int insertWalkParticipant(WalkParticipantDTO participant){		
		return mapper.insertWalkParticipant(participant);
	};

	// Route Rating create
	@Override
	public int insertRouteRating(RouteRatingDTO userRating){		
		return mapper.insertRouteRating(userRating);
	};

	// User rating create
	@Override
	public int insertUserRating(UserRatingDTO userRating){		
		return mapper.insertUserRating(userRating);
	};

	
	/* <<<LIST, READ>>> */
	// ?????? ?????? ?????? ??????
	@Override
	public List<WalkRouteDTO> getRouteList(int memberNo){		
		return mapper.getRouteList(memberNo);
	};	
	
	// ?????? ?????? ??????
	@Override
	public List<WalkMyRouteDTO> getMyRouteList(int memberNo){		
		return mapper.getMyRouteList(memberNo);
	};	
	
	// ?????? ?????? ?????? 
	@Override
	public WalkRouteDTO getRoute(int routeNo){		
		return mapper.getRoute(routeNo);
	};
	
	// ?????? ???????????? ?????? 
	@Override
	public WalkMyRouteDTO getMyRoute(int routeNo){		
		return mapper.getMyRoute(routeNo);
	};
	
	// ?????? ?????? ?????? ??????
	@Override
	public RouteRatingDTO getRouteRating(int routeRatingNo){		
		return mapper.getRouteRating(routeRatingNo);
	};

	// ????????? ?????? ??????
	@Override
	public UserRatingDTO getUserRating(int userRatingNo){		
		return mapper.getRatingUser(userRatingNo);
	};

	// ?????? ?????? ??????
	@Override
	public WalkPartyDTO getWalkParty(int partyNo){		
		return mapper.getWalkParty(partyNo);
	};

	// ?????? ????????? ??????
	@Override
	public List<WalkParticipantDTO> getPartyParticipant(int walkParticipantNo){		
		return mapper.getPartyParticipant(walkParticipantNo);
	};	


	/* <<<DELETE>>> */
	
	// ?????? ??????
	@Override
	public int deleteRoute(int routeNo){		
		return mapper.deleteRoute(routeNo);
	};
	
	// ???????????? ??????
	@Override
	public int deleteMyRoute(int myRouteNo){		
		return mapper.deleteMyRoute(myRouteNo);
	};
	
	// ?????? ????????? ??????
	@Override
	public int deleteWalkParticipant(int walkParticipantNo){		
		return mapper.deleteWalkParticipant(walkParticipantNo);
	}
	@Override
	public WalkRouteDTO getRoute(int memberNo, String routeName) {
		// TODO Auto-generated method stub
		return mapper.getRoute(memberNo,routeName);
	}
	@Override
	public List<WalkRouteDTO> getRouteList(int memberNo, String routeName) {
		// TODO Auto-generated method stub
		return mapper.getRouteList(memberNo,routeName);
	}
	@Override
	public List<WalkParticipantDTO> insertWalkParticipant(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return  mapper.insertWalkParticipant(map);
	};
	

	
}