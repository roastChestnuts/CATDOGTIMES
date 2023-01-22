package com.catdog.times.post.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.catdog.times.post.model.dto.BookmarkDTO;
import com.catdog.times.post.model.dto.FollowDTO;
import com.catdog.times.post.model.dto.ImageDTO;
import com.catdog.times.post.model.dto.NotificationDTO;
import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.PostLikeDTO;
import com.catdog.times.post.model.dto.ReadReplyDTO;
import com.catdog.times.post.model.dto.RecommendDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.ReplyLikeDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.dto.SearchMemberDTO;
import com.catdog.times.post.model.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper mapper;
	
	//등록	
	//글쓰기+insertHashtag+insertImage	
	@Override
	@Transactional
	public int insertPost(PostDTO post, MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		//insertPost	
		mapper.insertPost(post);
		int postId = post.getPostId();
		
		//insertPostHashtag
		String postHashtag = post.getPostHashtag();
		PostHashtagDTO hashtag = new PostHashtagDTO();
		hashtag.setPostId(postId);
		hashtag.setPostHashtag(postHashtag);
		mapper.insertHashtag(hashtag);
		
		//insertImage
		System.out.println("서비스 file 들어왔을까?:"+file);
		
		String ImageOriginalName = post.getImageOriginalName();
		String ImageSavedName = post.getImageSavedName();
		
		ImageDTO image = new ImageDTO();				
		image.setImageOriginalName(ImageOriginalName);
		image.setImageSavedName(ImageSavedName);
		image.setPostId(postId);
		
		String path = WebUtils.getRealPath(session.getServletContext(), "/resources/upload");
		System.out.println("post서비스 업로드 실제경로:"+path);
		
		if(!file.isEmpty()) {
			file.transferTo(new File(path+File.separator+image.getImageSavedName()));
		}
		
		mapper.insertImage(image);
		
		return 0; 
	}
	
	@Override
	public int insertHashtag(PostHashtagDTO postHashtagList) {
		System.out.println("이곳은 서비스(해시태그)"+ postHashtagList);
		return mapper.insertHashtag(postHashtagList);
	}
	
	@Override
	public int insertImage(ImageDTO image) {
		return mapper.insertImage(image);
	}
	
	
//	@Override
//	public int insertImage(ImageDTO image, MultipartFile photofile, HttpSession session) throws IllegalStateException, IOException {	
//		String path = WebUtils.getRealPath(session.getServletContext(), "/resources/upload");
//		System.out.println("ServiceImpl: 실제경로" + path);
//				
//		if(photofile != null){
//			String filename = fileuploadservice.uploadFile(photofile, path);			
//			image.setImageSavedName(filename);
//		}			
//		return 0;
//	}

//	@Override
////	public int insertImage(@RequestPart("image") ImageDTO image, @RequestPart(required = false) MultipartFile photofile, HttpSession session) {
////		return mapper.insertImage(image);
////	}

	@Override
	public int insertLike(PostLikeDTO postLike) {		
		return mapper.insertLike(postLike);
	}

	@Override
	public int insertReply(ReplyDTO reply) {
		return mapper.insertReply(reply);
	}

	@Override
	public int insertReplyLike(ReplyLikeDTO replyLike) {		
		return mapper.insertReplyLike(replyLike);
	}

	@Override
	public int insertBookmark(BookmarkDTO bookmark) {
		return mapper.insertBookmark(bookmark);
	}
	
	//List·Read
	
	@Override
	public List<SNSFeedDTO> selectAllPost() {
		return mapper.selectAllPost();
	}

	@Override
	public PostDTO readPost(int postId) {		
		return mapper.readPost(postId);
	}
	
	@Override
	public List<ReadReplyDTO> readReply(int postId) {		
		return mapper.readReply(postId);
	}
	
	@Override
	public List<PostDTO> findByContent(String postContent) {		
		return mapper.findByContent(postContent);
	}

	@Override
	public List<PostDTO> findByHashtag(String postHashtag) {
		// #으로 시작하는 걸로 찾아야 하나?
		return mapper.findByHashtag(postHashtag);
	}

	@Override
	public ImageDTO findImageById(int imageId) {
		// 탐색으로 랜덤 아이디를 보내줘야 함...
		// 이걸 최소 9번 호출해야 하는데 큼...
		imageId = (int)(Math.random()*10); //0~9까지		
		return mapper.findImageById(imageId);
	}
	
	//Update	
	@Override
	public int postUpdate(PostDTO post) {		
		return mapper.postUpdate(post);
	}

	@Override
	public int hashtagUpdate(PostHashtagDTO postHashtag) {		
		return mapper.hashtagUpdate(postHashtag);
	}

	@Override
	public int replyUpdate(ReplyDTO reply) {		
		return mapper.replyUpdate(reply);
	}
	
	//Delete	
	@Override
	public int deleteBookmark(int bookmarkId) {
		return mapper.deleteBookmark(bookmarkId);
	}

	@Override
	public int deleteReplyLike(int replyLikeId) {		
		return mapper.deleteReplyLike(replyLikeId);
	}

	@Override
	public int deletePostLike(int postLikeId) {		
		return mapper.deletePostLike(postLikeId);
	}

	@Override
	public int deletePostHashtag(int postHashtagId) {		
		return mapper.deletePostHashtag(postHashtagId);
	}

	@Override
	public int deleteReply(int replyId) {		
		return mapper.deleteReply(replyId);
	}

	@Override
	public int deleteImage(int imageId) {		
		return mapper.deleteImage(imageId);
	}

	@Override
	public int deletePost(int postId) {		
		return mapper.deletePost(postId);
	}

	//게시글 좋아요 인서트
	@Override
	public int insertPostLike(PostLikeDTO postLikeDto) {
		return mapper.insertPostLike(postLikeDto);
	}
	//게시글 좋아요 조회
//	@Override
//	public List<PostLikeDTO> readPostLike(PostLikeDTO postLikeDto) {
//		return mapper.readPostLike(postLikeDto);
//	}
	@Override
	public List<PostLikeDTO> readPostLike(PostLikeDTO postDto) {
		return mapper.readPostLike(postDto);
	}

	//검색
	@Override
	public List<SearchMemberDTO> searchUser(String id) {
		return mapper.searchUser(id);
	}

	//특정 유저 탐색페이지 조회
	@Override
	public List<ImageDTO> searchExploreImage(int toMemberNo) {
		return mapper.searchExploreImage(toMemberNo);
	}
	
	//랜덤 탐색페이지 조회
	@Override
	public List<ImageDTO> searchExploreImage() {
		return mapper.searchRandomExploreImage();
	}
	
	//알림창 조회(좋아요 누른 사람들)
	@Override
	public List<NotificationDTO> searchNotifications(String memberNo) {
		return mapper.searchNotifications(memberNo);
	}
	
	//알림창 조회(추천인들)
	@Override
	public List<RecommendDTO> searchRecommends(String memberNo) {
		return mapper.searchRecommends(memberNo);
	}
	
	//팔로우 읽어오기
	@Override
	public List<FollowDTO> readFollow(FollowDTO followDto) {		
		return mapper.readFollow(followDto);
	}
	//팔로우 저장
	@Override
	public int insertFollow(FollowDTO followDto) {
		return mapper.insertFollow(followDto);
	}

	//팔로우 취소
	@Override
	public int deleteFollow(FollowDTO followDto) {
		return mapper.deleteFollow(followDto);
	}
}
