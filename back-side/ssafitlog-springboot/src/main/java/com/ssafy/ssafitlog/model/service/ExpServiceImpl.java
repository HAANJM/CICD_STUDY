package com.ssafy.ssafitlog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.ExpDao;

@Service
public class ExpServiceImpl implements ExpService {
	
	@Autowired
	private ExpDao expDao;

}
