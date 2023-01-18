package com.catdog.times.route.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.PostLikeDTO;
import com.catdog.times.post.model.dto.ReadReplyDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.service.PostService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/route")
public class RouteController {
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
	

	/* 해시태그 insert */
	@RequestMapping(value = "/addHashtag", method = RequestMethod.POST)
	public int insertHashtag(@RequestBody PostHashtagDTO postHashtagList) {
		System.out.println("Controller(해시태그):" + postHashtagList);
		int result = service.insertHashtag(postHashtagList);
		return result;
	}
	
	//게시글 좋아요 조회(Dto엔 postId만 담겨올 것)
	@GetMapping("/like")
	public List<PostLikeDTO> selectPostLike(@RequestBody PostLikeDTO postLikeDto, HttpServletRequest request) {
		int memberNo = (int)request.getAttribute("userId");
		postLikeDto.setMemberNo(memberNo);
		return service.readPostLike(postLikeDto);
	}
		
	//게시글 좋아요 인서트, 좋아요 삭제
	@PostMapping("/like")
	public int updatePostLike(HttpServletRequest request, String postId, int postLikeId) {
		String memberNo = (String)request.getAttribute("userId");
		int result = 0;
		//게시글에 좋아요를 누르지 않은 경우
		if(postLikeId == 0) {
			result = service.insertPostLike(postId, memberNo); //게시글 좋아요 번호 리턴
		}else {
			service.deletePostLike(postLikeId);
		}
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