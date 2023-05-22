package com.ssafy.ssafitlog.model.service;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Review;
import com.ssafy.ssafitlog.model.dto.ReviewContainBoard;

public interface ReviewService {
	boolean registReview(ReviewContainBoard reviewContainBoard);
	
	List<Review> searchReviewAll(int boardNumber);
	
	Review searchReview(int reviewNumber);
	
	boolean modifyReview(ReviewContainBoard reviewContainBoard);
	
	boolean deleteReview(ReviewContainBoard reviewContainBoard);
}
