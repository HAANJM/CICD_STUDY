package com.ssafy.ssafitlog.model.dto;

public class Review {
	private int reviewNumber; // 리뷰 고유번호
	private int boardNumber; // 리뷰가 속한 게시판의 고유번호
	private String userId;
	private String regDate; // 리뷰 등록 날짜
	private String reviewContent;
	private int reviewScore; // 리뷰가 부여한 평가 점수, -1, 0 ,1로 구성
	private int reviewStatus; // 리뷰 상태, 0 = 일반 댓글, 1 = 평가 댓글 (점수 부여 가능)
	
	public Review() {};
	
	public int getReviewNumber() {
		return reviewNumber;
	}
	public void setReviewNumber(int reviewNumber) {
		this.reviewNumber = reviewNumber;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
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
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	

	public int getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	@Override
	public String toString() {
		return "Review [reviewNumber=" + reviewNumber + ", boardNumber=" + boardNumber + ", userId=" + userId
				+ ", regDate=" + regDate + ", reviewContent=" + reviewContent + ", reviewScore=" + reviewScore
				+ ", reviewStatus=" + reviewStatus + "]";
	}
	
	
//	public int getStatus() {
//		return status;
//	}
//	public void setStatus(int status) {
//		this.status = status;
//	}
//	
//	@Override
//	public String toString() {
//		return "Review [reviewNumber=" + reviewNumber + ", boardNumber=" + boardNumber + ", userId=" + userId
//				+ ", regDate=" + regDate + ", reviewContent=" + reviewContent + ", reviewScore=" + reviewScore
//				+ ", status=" + status + "]";
//	}
	
}
