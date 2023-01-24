package com.catdog.times.post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catdog.times.post.model.dto.FollowDTO;
import com.catdog.times.post.model.dto.ImageDTO;
import com.catdog.times.post.model.dto.NotificationDTO;
import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostLikeDTO;
import com.catdog.times.post.model.dto.ReadReplyDTO;
import com.catdog.times.post.model.dto.RecommendDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.dto.SearchMemberDTO;
import com.catdog.times.post.model.service.PostService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {
	@Autowired
	private PostService service;

	/* SNS 게시글 */
	// SNS 게시글 작성
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertPost(@RequestPart("post") PostDTO post, @RequestPart(required = false) MultipartFile file, HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		System.out.println(memberNo);
		post.setMemberNo(memberNo);		
		System.out.println(post);
		System.out.println("컨트롤러:" + file);
		int result = service.insertPost(post, file, session);
		System.out.println("=====insertPost========");
		System.out.println("insertPost 결과값:" + result);
		return "성공";
	}

	// SNS 게시글(Post) 전체조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<SNSFeedDTO> selectAllPost() {
		List<SNSFeedDTO> postList = service.selectAllPost();
		return postList;
	}

	// SNS 게시글 id 조회

	// SNS 게시글 수정
	public int postUpdate(PostDTO post) {
		int result = service.postUpdate(post);
		return result;
	}

	// SNS 게시글 삭제
	@PostMapping("/delete")
	public int deletePost(int postId) {
//		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		int result = service.deletePost(postId);
		return result;
	}

	/* 해시태그 insert */
//	@RequestMapping(value = "/addHashtag", method = RequestMethod.POST)
//	public int insertHashtag(@RequestBody PostHashtagDTO postHashtagList) {
//		System.out.println("Controller(해시태그):" + postHashtagList);
//		int result = service.insertHashtag(postHashtagList);
//		return result;
//	}

	// 게시글 좋아요 조회(Dto엔 postId만 담겨올 것)
	@GetMapping("/like")
	public List<PostLikeDTO> selectPostLike(PostLikeDTO postLikeDto, HttpServletRequest request) {
		System.out.println("좋아요 get:" + postLikeDto);
		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		postLikeDto.setMemberNo(memberNo);
		System.out.println(service.readPostLike(postLikeDto));
		return service.readPostLike(postLikeDto);
	}

//	//게시글 좋아요 인서트, 좋아요 삭제
//	@PostMapping("/like")
//	public int updatePostLike(HttpServletRequest request, String postId, int postLikeId) {
//		String memberNo = (String)request.getAttribute("userId");
//		int result = -1;
//		//게시글에 좋아요를 누르지 않은 경우
//		if(postLikeId < 0) {
//			result = service.insertPostLike(postId, memberNo); //게시글 좋아요 번호 리턴
//		}else {
//			service.deletePostLike(postLikeId);
//		}
//		return result;
//	}

	// 게시글 좋아요 인서트, 좋아요 삭제
	@PostMapping("/like")
	public PostLikeDTO updatePostLike(HttpServletRequest request, // 담겨와야 하는 값
			@RequestBody PostLikeDTO postLikeDto /* ,String postId, int postLikeId */) {
		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		System.out.println(memberNo);
		int postLikeId = postLikeDto.getPostLikeId();
		PostLikeDTO result = null;
		postLikeDto.setMemberNo(memberNo);

		// 게시글에 좋아요를 누르지 않은 경우
		if (postLikeId < 0) {
			// PostLikeDTO 리턴
			service.insertPostLike(postLikeDto);
			result = postLikeDto;// 게시글 좋아요 번호 리턴
		} else {
			service.deletePostLike(postLikeId);
		}
		return result;
	}

	// 검색
	@GetMapping("/search")
	public List<SearchMemberDTO> searchUser(HttpServletRequest request, String id) {
		String memberNo = (String) request.getAttribute("userId");
		log.info(memberNo, id);
		List<SearchMemberDTO> result = new ArrayList<>();
		if (id != null) {
			result = service.searchUser(id); // 파라미터 아이디로 조회
		}
		return result;
	}

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

	// 알림창 조회(좋아요 누른 사람들)
	@GetMapping("/notifications")
	public List<NotificationDTO> searchNotifications(HttpServletRequest request) {
		String memberNo = (String) request.getAttribute("userId");
		log.info("알림창 조회[좋아요]", memberNo);
		List<NotificationDTO> result = new ArrayList<>();

		result = service.searchNotifications(memberNo); // 파라미터 아이디로 조회

		return result;
	}

	// 알림창 조회(추천인들)
	@GetMapping("/recommends")
	public List<RecommendDTO> searchRecommends(HttpServletRequest request) {
		String memberNo = (String) request.getAttribute("userId");
		log.info("알림창 조회[추천인]", memberNo);
		List<RecommendDTO> result = new ArrayList<>();

		result = service.searchRecommends(memberNo); // 파라미터 아이디로 조회

		return result;
	}
	
	// 업데이트 이전에 팔로우 돼 있는지 확인
	@GetMapping("/follow")
	public List<FollowDTO> selectFollow(HttpServletRequest request, FollowDTO followDto){
		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		followDto.setFollowerId(memberNo);
		return service.readFollow(followDto);
	} 
	
	// 팔로우 업데이트
	@PostMapping("/follow") // int followId, int followingId
	public FollowDTO updateFollow(HttpServletRequest request, @RequestBody FollowDTO followDto) {
		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		System.out.println(memberNo);
		followDto.setFollowerId(memberNo);

		FollowDTO result = null;
		// 팔로우 돼있지 않은 경우
		if (followDto.getFollowId() <= 0) {
			// followDTO 리턴
			service.insertFollow(followDto);
			result = followDto;
		} else {
			// 삭제일 경우 null 리턴
			service.deleteFollow(followDto);
		}
		return result;
	}	

	/* 댓글 */
	/* 댓글 insert */
	@RequestMapping(value = "/insertReply", method = RequestMethod.POST)
	public int insertReply(@RequestBody ReplyDTO reply, HttpServletRequest request) {
		int memberNo = Integer.parseInt(String.valueOf(request.getAttribute("userId")));
		reply.setMemberNo(memberNo);
		System.out.println("insertReply Controller:" + reply);
		int result = service.insertReply(reply);
		return result;
	}

	/* 댓글 불러오기 */
	@RequestMapping(value = "/readReply", method = RequestMethod.GET)
	public List<ReadReplyDTO> readReply(int postId) {
		List<ReadReplyDTO> replyList = service.readReply(postId);
		return replyList;
	}
}