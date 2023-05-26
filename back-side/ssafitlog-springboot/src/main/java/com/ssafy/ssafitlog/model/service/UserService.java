package com.ssafy.ssafitlog.model.service;

import com.ssafy.ssafitlog.model.dto.StricExpDiff;
import com.ssafy.ssafitlog.model.dto.User;

public interface UserService {
	
	User getUser(String userId);
	
	Integer getUserByEmail(String email);
	
	int userRegist(User user);
	
	int modifyUser(User user);
	
	int deleteUser(User user);
	
	int modifyPassword(User user);
	
	String searchUserId(User user); // 이 유저에는 userId는 없고 이름이랑 이메일만 있음
	
	int modifyStricExp(StricExpDiff exp);
	
	int upReviewExp(StricExpDiff exp);
	
	int downReviewExp(StricExpDiff exp);
	
	String searchUserImg(String userId);
	
	int searchUserReviewCount(String userId);
}
