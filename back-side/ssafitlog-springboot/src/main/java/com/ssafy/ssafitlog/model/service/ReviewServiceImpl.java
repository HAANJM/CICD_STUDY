package com.ssafy.ssafitlog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafitlog.model.dao.ReviewDao;
import com.ssafy.ssafitlog.model.dto.Review;
import com.ssafy.ssafitlog.model.dto.ReviewContainBoard;
import com.ssafy.ssafitlog.model.dto.StricExpDiff;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ExpService expService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean registReview(ReviewContainBoard reviewContainBoard) {
		// 리뷰 등록
		reviewDao.insertReview(reviewContainBoard);
		reviewContainBoard.setRegDate(reviewDao.selectReview(reviewContainBoard.getReviewNumber()).getRegDate());
		// status가 0일 경우 (일반 댓글), 점수 조정 작업 필요 없음
		if (reviewContainBoard.getReviewStatus() == 0) return true;
		// 현재 등록 한 댓글로 인해 변동된 게시글 평가 점수 반영 및 scoreCountSum 가져오기
		boardService.modifyScoreCount(reviewContainBoard);
		
		// scoreCountSum을 stricExp로 변환
		if (reviewContainBoard.getScoreCountSum() == null) {
			reviewContainBoard.setScoreCountSum(0);
		}
		int stricExp = expService.convertScoreToExp(reviewContainBoard.getScoreCountSum());
		
		// user의 totalExp에 반영할 strixExpDiff를 만든다.
		StricExpDiff exp = new StricExpDiff();
		exp.setUserId(reviewContainBoard.getBoardUserId());
		exp.setRegDate(reviewContainBoard.getBoardRegDate());
		exp.setStricExp(stricExp);
		expService.modifyStricExp(exp);
		userService.modifyStricExp(exp);
		// 만약 댓글러의 리뷰 횟수가 5회 이하면, 평가 경험치 증가
		if (reviewContainBoard.getReviewCount() < 5) {
			System.out.println("666");
			exp.setRegDate(reviewContainBoard.getRegDate());
			exp.setUserId(reviewContainBoard.getUserId());
			exp.setReviewExp(1); // 반영할 점수
			expService.modifyReviewExp(exp);
			userService.upReviewExp(exp);
		}
		return true;
	}

	@Override
	public List<Review> searchReviewAll(int boardNumber) {
		// TODO Auto-generated method stub
		return reviewDao.selectReviewAll(boardNumber);
	}

	@Override 
	public boolean modifyReview(ReviewContainBoard reviewContainBoard) {
		// 리뷰 status 변화를 확인해야 하기에 DB에 원래 있던 review 정보 가져오기
		Review previous = searchReview(reviewContainBoard.getReviewNumber());
		
		// 리뷰 수정
		reviewDao.updateReview(reviewContainBoard);
		// 만약 수정 전, 수정 후 status가 0이면 점수 작업 할 필요 없음
		if (reviewContainBoard.getReviewStatus() + previous.getReviewStatus() == 0) return true; // modify한 리뷰가 평가 x 상태의 리뷰면 여기서 종료
		reviewContainBoard.setReviewScore(reviewContainBoard.getReviewScore() - previous.getReviewScore());
		// 해당 게시글에 대한 reviewScore 반영 및 게시글 작성일에 대한 scoreCountSum 가져오기
		boardService.modifyScoreCount(reviewContainBoard);
		
		// scoreCountSum을 stricExp로 변환
		if (reviewContainBoard.getScoreCountSum() == null) {
			reviewContainBoard.setScoreCountSum(0);
		}
		int stricExp = expService.convertScoreToExp(reviewContainBoard.getScoreCountSum());
		// user의 totalExp에 반영할 strixExpDiff를 만든다.
		StricExpDiff exp = new StricExpDiff();
		exp.setUserId(reviewContainBoard.getBoardUserId());
		exp.setRegDate(reviewContainBoard.getBoardRegDate());
		exp.setStricExp(stricExp);
		expService.modifyStricExp(exp);
		userService.modifyStricExp(exp);
		// 수정 전 및 수정 후 status가 1로 동일하다면 경험치 반영할 필요 없음
		if (previous.getReviewStatus() * reviewContainBoard.getReviewStatus() == 1) return true; // 이전에도 평가상태였으면 댓글러의 기여점수를 올릴 필요는 없음
		
		// status 0 -> 1이면 경험치 증가, 1 -> 0이면 감소시켜야 하고 
		// 증가, 감소에 따라 reviewCount 확인할 범위가 다름
		int statusDiff = reviewContainBoard.getReviewStatus() - previous.getReviewStatus();
		exp.setReviewExp(statusDiff);
		exp.setRegDate(reviewContainBoard.getRegDate());
		exp.setUserId(reviewContainBoard.getUserId());
		if (statusDiff == 1) {
			if (reviewContainBoard.getReviewCount() < 5) {
				expService.modifyReviewExp(exp);
				userService.upReviewExp(exp);
			}
		} else {
			if (reviewContainBoard.getReviewCount() <= 5) {
				expService.modifyReviewExp(exp);
				userService.downReviewExp(exp);
			}
		}
		
		return true;
	}

	@Override
	public boolean deleteReview(ReviewContainBoard reviewContainBoard) {
		// 리뷰 제거
		reviewDao.deleteReview(reviewContainBoard.getReviewNumber());
		// 제거한 리뷰 status가 0이면 추가 작업 필요 없음
		if (reviewContainBoard.getReviewStatus() == 0) return true;
		
		// 리뷰가 제거되었으므로 기존 리뷰가 반영한 값의 반대값을 modify시킨다.
		reviewContainBoard.setReviewScore(reviewContainBoard.getReviewScore() * (-1));
		boardService.modifyScoreCount(reviewContainBoard);
		
		// scoreCountSum을 stricExp로 변환
		if (reviewContainBoard.getScoreCountSum() == null) {
			reviewContainBoard.setScoreCountSum(0);
		}
		int stricExp = expService.convertScoreToExp(reviewContainBoard.getScoreCountSum());
		
		// user의 totalExp에 반영할 strixExpDiff를 만든다.
		StricExpDiff exp = new StricExpDiff();
		exp.setUserId(reviewContainBoard.getBoardUserId());
		exp.setRegDate(reviewContainBoard.getBoardRegDate());
		exp.setStricExp(stricExp);
		expService.modifyStricExp(exp);
		userService.modifyStricExp(exp);
		// 리뷰 제거했으므로 등록한 평가 횟수가 5회 이하일땐 점수 반영을 한다.
		if (reviewContainBoard.getReviewCount() <= 5) {
			exp.setRegDate(reviewContainBoard.getRegDate());
			exp.setUserId(reviewContainBoard.getUserId());
			exp.setReviewExp(-1);
			expService.modifyReviewExp(exp);
			userService.downReviewExp(exp);
		}
		return true;
	}

	@Override
	public Review searchReview(int reviewNumber) {
		return reviewDao.selectReview(reviewNumber);
	}
}
