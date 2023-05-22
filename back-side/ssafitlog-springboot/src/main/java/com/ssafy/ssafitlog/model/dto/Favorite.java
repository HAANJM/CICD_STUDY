package com.ssafy.ssafitlog.model.dto;

public class Favorite {

	private String userId;
	private int boardNumber;
	
	public Favorite() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	@Override
	public String toString() {
		return "Like [userId=" + userId + ", boardNumber=" + boardNumber + "]";
	};

}
