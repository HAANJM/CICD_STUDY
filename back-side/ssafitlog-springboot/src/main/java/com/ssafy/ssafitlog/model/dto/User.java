package com.ssafy.ssafitlog.model.dto;

public class User {
	
	private String userId;
	private String userComment;
	private String img;
	private String oriImg;
	private String password;
	private String email;
	private String nickName;
	private String userName;
	private int totalExp;
	private int level;
	private String tier;
	private String userUserStatus;
	public User() {
		super();
	}
	public User(String userId, String userComment, String img, String oriImg, String password, String email,
			String nickName, String userName, int totalExp, int level, String tier, String userUserStatus) {
		super();
		this.userId = userId;
		this.userComment = userComment;
		this.img = img;
		this.oriImg = oriImg;
		this.password = password;
		this.email = email;
		this.nickName = nickName;
		this.userName = userName;
		this.totalExp = totalExp;
		this.level = level;
		this.tier = tier;
		this.userUserStatus = userUserStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getOriImg() {
		return oriImg;
	}
	public void setOriImg(String oriImg) {
		this.oriImg = oriImg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getUserStatus() {
		return userUserStatus;
	}
	public void setUserStatus(String userUserStatus) {
		this.userUserStatus = userUserStatus;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userComment=" + userComment + ", img=" + img + ", oriImg=" + oriImg
				+ ", password=" + password + ", email=" + email + ", nickName=" + nickName + ", userName=" + userName
				+ ", totalExp=" + totalExp + ", level=" + level + ", tier=" + tier + ", userUserStatus=" + userUserStatus + "]";
	}
	
	

}
