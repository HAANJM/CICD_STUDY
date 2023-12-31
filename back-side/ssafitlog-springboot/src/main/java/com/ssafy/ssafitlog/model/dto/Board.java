package com.ssafy.ssafitlog.model.dto;

public class Board {
	private int boardNumber; // 게시판 고유번호
	private String userId; // 게시판 작성자 id
	private String regDate; // 등록날짜
	private String boardTitle;
	private String boardContent;
	private String link; // 유튜브 링크, 뒤에 키값만 잘라옴
	private int scoreCount; // 게시판 평가 점수, 해당 게시판 모든 평가점수의 합
	private int favoriteCount; // 좋아요 횟수
	
	public Board(){};
	
	
	
	public Board(int boardNumber, String userId, String regDate, String boardTitle, String boardContent, String link,
			int scoreCount, int favoriteCount) {
		super();
		this.boardNumber = boardNumber;
		this.userId = userId;
		this.regDate = regDate;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.link = link;
		this.scoreCount = scoreCount;
		this.favoriteCount = favoriteCount;
	}



	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
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
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getScoreCount() {
		return scoreCount;
	}
	public void setScoreCount(int scoreCount) {
		this.scoreCount = scoreCount;
	}
	public int getfavoriteCount() {
		return favoriteCount;
	}
	public void setfavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	@Override
	public String toString() {
		return "Board [boardNumber=" + boardNumber + ", userId=" + userId + ", regDate=" + regDate + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", link=" + link + ", scoreCount=" + scoreCount
				+ ", favoriteCount=" + favoriteCount + "]";
	}
	
}
