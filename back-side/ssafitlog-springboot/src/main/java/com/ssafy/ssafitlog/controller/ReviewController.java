package com.ssafy.ssafitlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.dto.Review;
import com.ssafy.ssafitlog.model.dto.ReviewContainBoard;
import com.ssafy.ssafitlog.model.service.ReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@ApiOperation(value="리뷰 등록", notes = "리뷰 등록 및 stricExp 처리")
	@PostMapping("/")
	public ResponseEntity<?> registReview(@RequestBody ReviewContainBoard reviewContainBoard) {
		System.out.println("시작");
		if (reviewService.registReview(reviewContainBoard)) {
			System.out.println("끝");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="리뷰 조회", notes = "게시글 관련 리뷰 다 불러오기")
	@GetMapping("/{boardNumber}")
	public ResponseEntity<?> searchReviewAll(@PathVariable int boardNumber) {
		List<Review> result = reviewService.searchReviewAll(boardNumber);
		return new ResponseEntity<List<Review>>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value="리뷰 수정", notes = "리뷰 수정 및 stricExp 처리")
	@PutMapping("")
	public ResponseEntity<?> modifyReview(@RequestBody ReviewContainBoard review) {
		if (reviewService.modifyReview(review)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="리뷰 삭제", notes = "리뷰 삭제 및 stricExp 처리")
	@DeleteMapping("")
	public ResponseEntity<?> deleteReview(@RequestBody ReviewContainBoard reviewContainBoard) {
		if (reviewService.deleteReview(reviewContainBoard)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
