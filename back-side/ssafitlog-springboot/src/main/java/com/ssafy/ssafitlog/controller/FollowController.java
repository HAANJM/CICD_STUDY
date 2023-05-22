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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.dto.Follow;
import com.ssafy.ssafitlog.model.dto.User;
import com.ssafy.ssafitlog.model.service.FollowService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/follow")
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	@ApiOperation(value="팔로우 등록", notes = "팔로우 등록")
	@PostMapping("")
	public ResponseEntity<?> registFollow(@RequestBody Follow follow) {
		if (followService.registFollow(follow)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="팔로우 검색", notes = "팔로우 검색")
	@GetMapping("/to/{userId}")
	public ResponseEntity<?> searchAllFollowTo(@PathVariable String userId) {
		List<User> result = followService.searchAllFollowTo(userId);
		System.out.println(result.toString());
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value="팔로워 검색", notes = "팔로워 검색")
	@GetMapping("/from/{userId}")
	public ResponseEntity<?> searchAllFollowFrom(@PathVariable String userId) {
		List<User> result = followService.searchAllFollowFrom(userId);
		System.out.println(result.toString());
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value="팔로우 삭제", notes = "팔로우 삭제")
	@DeleteMapping("")
	public ResponseEntity<?> deleteFollow(@RequestBody Follow follow) {
		if (followService.deleteFollow(follow)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
