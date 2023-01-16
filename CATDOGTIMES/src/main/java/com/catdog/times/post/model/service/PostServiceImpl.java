package com.catdog.times.post.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catdog.times.post.model.dto.BookmarkDTO;
import com.catdog.times.post.model.dto.ImageDTO;
import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.PostLikeDTO;
import com.catdog.times.post.model.dto.ReadReplyDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.ReplyLikeDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostMapper mapper;
	
	//등록
	
	//글쓰기, image 넣기가 분리되어 있는데, 이럴 땐 transactional 어떻게 하나?
	//같이 해야 하나?
	@Override
	public int insertPost(PostDTO post) {		
		return mapper.insertPost(post);
	}

	@Override
	public int insertImage(ImageDTO image) {
		//첨부파일... transactional 처리해야하나?
		return mapper.insertImage(image);
	}

	@Override
	public int insertLike(PostLikeDTO postLike) {		
		return mapper.insertLike(postLike);
	}

	@Override
	public int insertHashtag(PostHashtagDTO postHashtagList) {
		System.out.println("이곳은 서비스(해시태그)"+ postHashtagList);
		return mapper.insertHashtag(postHashtagList);
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
	public int insertPostLike(String postId, String memberNo) {
		return mapper.insertPostLike(postId, memberNo);
	}
	//게시글 좋아요 조회
	@Override
	public List<PostLikeDTO> readPostLike(PostLikeDTO postLikeDto) {
		return mapper.readPostLike(postLikeDto);
	}

}
