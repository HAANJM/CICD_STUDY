package com.ssafy.ssafitlog.model.dto;

public class Follow {
	private String followFrom;
	private String followTo;
	
	public Follow() {};
	
	public String getFollowFrom() {
		return followFrom;
	}
	public void setFollowFrom(String followFrom) {
		this.followFrom = followFrom;
	}
	public String getFollowTo() {
		return followTo;
	}
	public void setFollowTo(String followTo) {
		this.followTo = followTo;
	}
	@Override
	public String toString() {
		return "Follow [followFrom=" + followFrom + ", followTo=" + followTo + "]";
	}
}
