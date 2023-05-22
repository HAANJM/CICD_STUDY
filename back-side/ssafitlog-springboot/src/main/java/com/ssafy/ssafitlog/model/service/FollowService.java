package com.ssafy.ssafitlog.model.service;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Follow;
import com.ssafy.ssafitlog.model.dto.User;

public interface FollowService {
	
	boolean registFollow(Follow follow);
	
	List<User> searchAllFollowTo(String userId);
	
	List<User> searchAllFollowFrom(String userId);
	
	boolean deleteFollow(Follow follow);
}
