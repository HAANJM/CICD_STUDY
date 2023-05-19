package com.ssafy.ssafitlog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.LikeDao;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeDao likeDao;

}
