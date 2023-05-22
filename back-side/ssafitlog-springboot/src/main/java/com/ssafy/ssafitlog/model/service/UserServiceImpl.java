package com.ssafy.ssafitlog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.UserDao;
import com.ssafy.ssafitlog.model.dto.StricExpDiff;
import com.ssafy.ssafitlog.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String userId) {
		return userDao.getUser(userId);
	}
	
	@Override
	public Integer getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public int userRegist(User user) {
		return userDao.userRegist(user);
	}

	@Override
	public int modifyUser(User user) {
		return userDao.modifyUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return userDao.deleteUser(user);
	}

	@Override
	public int modifyPassword(User user) {
		return userDao.modifyPassword(user);
	}

	@Override
	public String searchUserId(User user) {
		return userDao.searchUserId(user);
	}

	@Override
	public int modifyStricExp(StricExpDiff exp) {
		return userDao.updateStricExp(exp);
	}

	@Override
	public int upReviewExp(StricExpDiff exp) {
		return userDao.upReviewExp(exp);
	}

	@Override
	public int downReviewExp(StricExpDiff exp) {
		return userDao.downReviewExp(exp);
	}
}
