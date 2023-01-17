package com.catdog.times.post.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.catdog.times.member.model.dto.Member;
import com.catdog.times.post.model.dto.BookmarkDTO;
import com.catdog.times.post.model.dto.ImageDTO;
import com.catdog.times.post.model.dto.PostDTO;
import com.catdog.times.post.model.dto.PostHashtagDTO;
import com.catdog.times.post.model.dto.PostLikeDTO;
import com.catdog.times.post.model.dto.ReadReplyDTO;
import com.catdog.times.post.model.dto.ReplyDTO;
import com.catdog.times.post.model.dto.ReplyLikeDTO;
import com.catdog.times.post.model.dto.SNSFeedDTO;
import com.catdog.times.post.model.dto.SearchMemberDTO;

@Mapper
public interface PostMapper {
	/* <<<CREATE>>> */
	// SNS 게시글 등록
	int insertPost(PostDTO post);

	// 이미지 업로드
	int insertImage(ImageDTO image);

	//게시글 좋아요
	int insertPostLike(String postId, String memberNo);
	// 좋아요 클릭
	int insertLike(PostLikeDTO postLike);

	// SNS 게시글 해시태그 등록
	int insertHashtag(PostHashtagDTO postHashtagList);

	// 댓글 작성
	int insertReply(ReplyDTO reply);

	// 댓글 좋아요 클릭
	int insertReplyLike(ReplyLikeDTO replyLike);

	// 북마크 등록
	int insertBookmark(BookmarkDTO bookmark);

	/* <<<LIST, READ>>> */
	// POST 전체조회
	List<SNSFeedDTO> selectAllPost();	
	
	// 특정 게시물 닉네임으로 조회. 내 파트가 아닌 것으로 보임
/*	PostDTO findByNickname(String nickName);*/
	
	// 특정 게시물 상세조회 
	PostDTO readPost(int postId);
	
	// 특정 게시물 내용으로 조회
	List<PostDTO> findByContent(String postContent);

	// 특정 게시물 해시태그로 조회
	List<PostDTO> findByHashtag(String postHashtag);

	// 탐색
	ImageDTO findImageById(int imageId);
	
	// 댓글 불러오기
	List<ReadReplyDTO> readReply(int postId);
	
	/* <<UPDATE>> */
	// SNS 게시물 본문 수정
	int postUpdate(PostDTO post);

	// SNS 해시태그 수정
	int hashtagUpdate(PostHashtagDTO postHashtag);

	// SNS 댓글 수정
	int replyUpdate(ReplyDTO reply);

	/* <<<DELETE>>> */
	
	//북마크 삭제
	int deleteBookmark(int bookmarkId);
	
	//댓글 좋아요 삭제
	int deleteReplyLike(int replyLikeId);
	
	//게시글 좋아요 삭제(병찬) 
	int deletePostLike(int postLikeId);
	
	//게시글 해시태그 삭제
	int deletePostHashtag(int postHashtagId);
	
	//댓글 삭제
	int deleteReply(int replyId);
	
	//이미지 삭제
	int deleteImage(int imageId);
	
	//게시글 삭제
	int deletePost(int postId);

	//게시글 좋아요 조회
	List<PostLikeDTO> readPostLike(PostLikeDTO postLikeDto);

	//검색
	List<SearchMemberDTO> searchUser(String id);

	//특정 유저 탐색페이지 조회
	List<ImageDTO> searchExploreImage(int toMemberNo);

	//랜덤 탐색페이지 조회
	List<ImageDTO> searchRandomExploreImage();
}
