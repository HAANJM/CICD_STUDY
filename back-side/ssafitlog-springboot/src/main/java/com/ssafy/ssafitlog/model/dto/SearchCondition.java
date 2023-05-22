package com.ssafy.ssafitlog.model.dto;

public class SearchCondition {
	private String userId;
	private String type;
	private String word;
	private String regDate;
	private int period;
	
	public SearchCondition() {};
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "SearchCondition [userId=" + userId + ", type=" + type + ", word=" + word + ", regDate=" + regDate
				+ ", period=" + period + "]";
	}

}
