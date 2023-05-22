package com.ssafy.ssafitlog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafitlog.model.dao.ExpDao;
import com.ssafy.ssafitlog.model.dto.Exp;
import com.ssafy.ssafitlog.model.dto.StricExpDiff;

@Transactional
@Service
public class ExpServiceImpl implements ExpService {
	
	@Autowired
	private ExpDao expDao;
	
//	private int[] stricExpTable = {1, 3, 6, 10, 15}; // scoreCoutSum 크기에 따른 stricExp 레벨
	private int[] stricExpTable = {1, 2, 3, 4, 5}; // scoreCoutSum 크기에 따른 stricExp 레벨
	private final int EXP = 1; // 레벨 당 경험치
	
	@Override
	public boolean registExp(Exp exp) {
		return	expDao.insertExp(exp) == 1;
	}

	@Override
	public List<Exp> searchAllExp(String userId) {
		return expDao.selectAllExp(userId);
	}
	
	@Override
	public int modifyStricExp(StricExpDiff stricExpDiff) {
		return expDao.updateStricExp(stricExpDiff);
	}

	@Override
	public boolean modifyReviewExp(Exp exp) {
		return expDao.updateReviewExp(exp) == 1;
	}

	@Override
	public boolean deleteExp(String regDate) {
		return expDao.deleteExp(regDate) == 1;
	}

	@Override
	public int convertScoreToExp(int scoreCountSum) {
		for (int i = 0; i < stricExpTable.length; i++) {
			if (scoreCountSum < stricExpTable[i]) {
				return i * EXP;
			}
		}
		return 5 * EXP;
	}

	
}
