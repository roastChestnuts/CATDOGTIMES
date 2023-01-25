package com.catdog.times.post.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.times.post.model.dto.ImageDTO;
import com.catdog.times.post.model.service.PostService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class ExploreController {
	@Autowired
	private PostService service;
	
	// 탐색페이지
	@GetMapping("/explore")
	public List<ImageDTO> explore(HttpServletRequest request, int toMemberNo) {
		String fromMemberNo = (String) request.getAttribute("userId");
		log.info("탐색페이지 호출", fromMemberNo, toMemberNo);

		List<ImageDTO> result = new ArrayList<>();

		if (toMemberNo >= 0) {
			result = service.searchExploreImage(toMemberNo); // 이미지 조회
		} else {
			result = service.searchExploreImage(); // 이미지 조회
		}
		System.out.println(result.get(0));
		System.out.println(result.get(0).getImageSavedName());

		return result;
	}
}
