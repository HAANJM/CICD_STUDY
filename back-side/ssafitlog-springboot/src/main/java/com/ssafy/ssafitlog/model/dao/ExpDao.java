package com.ssafy.ssafitlog.model.dao;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Exp;
import com.ssafy.ssafitlog.model.dto.StricExpDiff;

public interface ExpDao {
	int insertExp(Exp exp);
	
	int updateStricExp(StricExpDiff exp);
	
	int updateReviewExp(Exp exp);
	
	List<Exp> selectAllExp(String userId);
	
	int deleteExp(String regDate);
}
