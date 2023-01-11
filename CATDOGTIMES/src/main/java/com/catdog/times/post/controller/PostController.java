package com.catdog.times.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService service;

	// SNS 게시글 작성
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertPost(@RequestBody PostDTO post) {
		System.out.println(post);
		int result = service.insertPost(post);
		System.out.println("insert 결과값:" + result);
		System.out.println("return값:" + post.getPostId());
		return "성공";
	}

	// SNS 게시글(Post) 전체조회

	@RequestMapping("/list")
	public ModelAndView selectAllpost() {
		ModelAndView mav = new ModelAndView("list");
		List<PostDTO> postlist = service.selectAllPost();
		mav.addObject("postlist", postlist);
		return mav;
	}

	// SNS 게시글 수정
	public ModelAndView postUpdate(PostDTO post) {
		ModelAndView mav = new ModelAndView();
		int result = service.postUpdate(post);
		if (result > 0) {
			mav.setViewName("redirect:/list");
		} else {
			mav.setViewName(null); // redirect 어디로?
		}
		mav.addObject("post", post);
		return mav;
	}
	// SNS 게시글 삭제 로그인 유무 체크 필요한가...

	@RequestMapping(value = "/delete")
	public String deletePost(String postId) {
		System.out.println(postId);
		// 로그인 사용자 찾기 (우선 pass)
		int result = service.deletePost(Integer.parseInt(postId));		
		return "성공";
	}
}
