package com.ssafy.ssafitlog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.FollowDao;
import com.ssafy.ssafitlog.model.dto.Follow;
import com.ssafy.ssafitlog.model.dto.User;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowDao followDao;

	@Override
	public boolean registFollow(Follow follow) {
		return followDao.insertFollow(follow) == 1;
	}

	@Override
	public List<User> searchAllFollowTo(String userId) {
		return followDao.selectAllFollowTo(userId);
	}

	@Override
	public List<User> searchAllFollowFrom(String userId) {
		return followDao.selectAllFollowFrom(userId);
	}

	@Override
	public boolean deleteFollow(Follow follow) {
		return followDao.deleteFollow(follow) == 1;
	}

}
