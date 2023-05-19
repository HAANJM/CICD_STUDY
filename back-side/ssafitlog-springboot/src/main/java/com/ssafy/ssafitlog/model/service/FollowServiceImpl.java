package com.ssafy.ssafitlog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.FollowDao;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowDao followDao;

}
