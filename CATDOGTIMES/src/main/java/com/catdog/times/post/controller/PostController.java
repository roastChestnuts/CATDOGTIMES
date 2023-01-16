package com.catdog.times.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.ReadReplyDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.service.PostService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService service;
	
	@Autowired
	private FileUploadLogic2 fileuploadservice;
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
	
	// SNS 게시글 삭제 
	@RequestMapping(value = "/delete")
	public int deletePost(int postId) {
		System.out.println(postId);
		//우선 아무나 삭제 가능하게 했는데, 이것도 memberNo와 게시글 작성자 일치할 때만 삭제하게끔 만들어야 함.
		int result = service.deletePost(postId);
		return result;
	}

	/* 해시태그 insert */
	@RequestMapping(value = "/addHashtag", method = RequestMethod.POST)
	public int insertHashtag(@RequestBody PostHashtagDTO postHashtagList) {
		System.out.println("Controller(해시태그):" + postHashtagList);
		int result = service.insertHashtag(postHashtagList);
		return result;
	}

	/* 댓글*/
	/* 댓글 insert */
	@RequestMapping(value="/insertReply", method = RequestMethod.POST)
	public int insertReply(@RequestBody ReplyDTO reply) {
		System.out.println("insertReply Controller:"+ reply);
		int result = service.insertReply(reply);
		return result;
	}	
	
	/* 댓글 불러오기 */
	@RequestMapping(value = "/readReply", method=RequestMethod.GET)
	public List<ReadReplyDTO> readReply(int postId) {
		List<ReadReplyDTO> replyList = service.readReply(postId);	
		return replyList;
	}
}
