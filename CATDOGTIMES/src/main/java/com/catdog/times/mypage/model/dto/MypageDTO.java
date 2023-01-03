package com.catdog.times.mypage.model.dto;

import java.sql.Date;

public class MypageDTO {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String memberNickname;
	private String memberEmail;
	private String memberIs;
	private String memberType;
	private int memberWarn;
	private Date memberCreateDate;
	private String memberPhoto;
	private String memberAddress;
	
	private int postTotal;
	private int followerCnt;
	private int followingCnt;
	
	public MypageDTO() {}

	
	public MypageDTO(int memberNo, String memberId, String memberPw, String memberName, String memberGender,
			String memberNickname, String memberEmail, String memberIs, String memberType, int memberWarn,
			Date memberCreateDate, String memberPhoto, String memberAddress, int postTotal, int followerCnt,
			int followingCnt) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberNickname = memberNickname;
		this.memberEmail = memberEmail;
		this.memberIs = memberIs;
		this.memberType = memberType;
		this.memberWarn = memberWarn;
		this.memberCreateDate = memberCreateDate;
		this.memberPhoto = memberPhoto;
		this.memberAddress = memberAddress;
		this.postTotal = postTotal;
		this.followerCnt = followerCnt;
		this.followingCnt = followingCnt;
	}


	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberIs() {
		return memberIs;
	}

	public void setMemberIs(String memberIs) {
		this.memberIs = memberIs;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getMemberWarn() {
		return memberWarn;
	}

	public void setMemberWarn(int memberWarn) {
		this.memberWarn = memberWarn;
	}

	public Date getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreateDate(Date memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getPostTotal() {
		return postTotal;
	}

	public void setPostTotal(int postTotal) {
		this.postTotal = postTotal;
	}

	public int getFollowerCnt() {
		return followerCnt;
	}

	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}

	public int getFollowingCnt() {
		return followingCnt;
	}

	public void setFollowingCnt(int followingCnt) {
		this.followingCnt = followingCnt;
	}

	@Override
	public String toString() {
		return "MypageDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberGender=" + memberGender + ", memberNickname=" + memberNickname
				+ ", memberEmail=" + memberEmail + ", memberIs=" + memberIs + ", memberType=" + memberType
				+ ", memberWarn=" + memberWarn + ", memberCreateDate=" + memberCreateDate + ", memberPhoto="
				+ memberPhoto + ", memberAddress=" + memberAddress + ", postTotal=" + postTotal + ", followerCnt="
				+ followerCnt + ", followingCnt=" + followingCnt + "]";
	}

}
