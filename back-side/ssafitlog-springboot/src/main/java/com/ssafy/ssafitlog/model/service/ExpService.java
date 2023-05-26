package com.ssafy.ssafitlog.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dto.Exp;
import com.ssafy.ssafitlog.model.dto.StricExpDiff;

@Service
public interface ExpService {
	boolean registExp(Exp exp);
	
	int modifyStricExp(StricExpDiff stricExpDiff);
	
	boolean modifyReviewExp(Exp exp);
	
	List<Exp> searchAllExp(String userId);
	
	boolean deleteExp(String regDate);
	
	int convertScoreToExp(int scoreCountSum);
	
	List<Exp> selectStric(String userId);
}
