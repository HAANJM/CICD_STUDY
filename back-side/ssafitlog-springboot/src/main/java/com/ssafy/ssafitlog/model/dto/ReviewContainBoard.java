package com.ssafy.ssafitlog.model.dto;

public class ReviewContainBoard extends Review{
	private String boardRegDate;
	private String boardUserId;
	private int scoreCountSum;
	private int reviewCount;
	
	public ReviewContainBoard() {};
	
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public int getScoreCountSum() {
		return scoreCountSum;
	}
	public void setScoreCountSum(int scoreCountSum) {
		this.scoreCountSum = scoreCountSum;
	}
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public String getBoardUserId() {
		return boardUserId;
	}
	public void setBoardUserId(String boardUserId) {
		this.boardUserId = boardUserId;
	}


	@Override
	public String toString() {
		return "ReviewContainBoard [boardRegDate=" + boardRegDate + ", boardUserId=" + boardUserId + ", reviewCount="
				+ reviewCount + ", scoreCountSum=" + scoreCountSum + ", getBoardRegDate()=" + getBoardRegDate()
				+ ", getBoardUserId()=" + getBoardUserId() + ", getReviewCount()=" + getReviewCount()
				+ ", getScoreCountSum()=" + getScoreCountSum() + ", getBoardNumber()=" + getBoardNumber() + ", getClass()="
				+ getClass() + ", getRegDate()=" + getRegDate() + ", getReviewContent()=" + getReviewContent()
				+ ", getReviewNumber()=" + getReviewNumber() + ", getReviewScore()=" + getReviewScore()
				+ ", getStatus()=" + getStatus() + ", getUserId()=" + getUserId() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
