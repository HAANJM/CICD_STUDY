package com.ssafy.ssafitlog.model.dao;

import com.ssafy.ssafitlog.model.dto.User;

public interface UserDao {
	
	User getUser(String userId);
	
	int userRegist(User user);
	
	int modifyUser(User user);
	
	int deleteUser(User user);
	
	int modifyPassword(User user);
	
	String searchUserId(User user); // 이 유저에는 userId는 없고 이름이랑 이메일만 있음

}
