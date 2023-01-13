package com.catdog.times.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.service.PostService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService service;

	/* SNS 게시글 */
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<SNSFeedDTO> selectAllPost() {
		List<SNSFeedDTO> postList = service.selectAllPost();
		System.out.println("잘들어오나 확인:" + postList);
		return postList;
	}

	// SNS 게시글 id 조회

	// SNS 게시글 수정
	public int postUpdate(PostDTO post) {
		int result = service.postUpdate(post);
		return result;
	}
	// SNS 게시글 삭제 로그인 유무 체크 필요한가...

	@RequestMapping(value = "/delete")
	public String deletePost(String postId) {
		System.out.println(postId);
		// 로그인 사용자 찾기 (우선 pass)
		int result = service.deletePost(Integer.parseInt(postId));
		return "성공" + result;
	}

	/* 해시태그 insert */

	@RequestMapping(value = "/addHashtag", method = RequestMethod.POST)
	public String insertHashtag(PostHashtagDTO postHashtag) {
		int result = service.insertHashtag(postHashtag);
		return "성공" + result;
	}

	/* 댓글 불러오기 */
	@RequestMapping(value = "/readReply", method=RequestMethod.GET)
	public List<ReplyDTO> readReply(int postId) {
		System.out.println("여기는 컨트롤러:"+ postId);
		List<ReplyDTO> replyList = service.readReply(postId);
		System.out.println("readReply 잘되나 확인:" + replyList);
		return replyList;
	}
}
