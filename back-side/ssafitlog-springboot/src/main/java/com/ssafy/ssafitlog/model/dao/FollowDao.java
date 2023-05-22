package com.ssafy.ssafitlog.model.dao;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Follow;
import com.ssafy.ssafitlog.model.dto.User;

public interface FollowDao {
	int insertFollow(Follow follow);
	
	List<User> selectAllFollowTo(String userId);
	
	List<User> selectAllFollowFrom(String userId);
	
	int deleteFollow(Follow follow);
}
