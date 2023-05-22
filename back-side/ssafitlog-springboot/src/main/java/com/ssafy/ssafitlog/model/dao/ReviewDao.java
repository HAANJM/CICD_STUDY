package com.ssafy.ssafitlog.model.dao;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Review;

public interface ReviewDao {
	int insertReview(Review review);
	
	List<Review> selectReviewAll(int boardNumber);
	
	Review selectReivew(int reviewNumber);
	
	int updateReview(Review review);
	
	int deleteReview(int reviewNumber);
}
