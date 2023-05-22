package com.ssafy.ssafitlog.model.dto;

public class Exp {
	private String userId;
	private String regDate; // 등록 날짜
	private int reviewExp; // 해당 날짜의 리뷰 경험치의 합
	private int stricExp; // 해당 날짜의 stric 경험치 합 (게시글 경험치 합)
	
	public Exp() {};
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getReviewExp() {
		return reviewExp;
	}

	public void setReviewExp(int reviewExp) {
		this.reviewExp = reviewExp;
	}

	public int getStricExp() {
		return stricExp;
	}

	public void setStricExp(int stricExp) {
		this.stricExp = stricExp;
	}

	@Override
	public String toString() {
		return "Exp [userId=" + userId + ", regDate=" + regDate + ", reviewExp=" + reviewExp + ", stricExp=" + stricExp
				+ "]";
	}
	
	
}
