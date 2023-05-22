package com.ssafy.ssafitlog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.UserDao;
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

}
