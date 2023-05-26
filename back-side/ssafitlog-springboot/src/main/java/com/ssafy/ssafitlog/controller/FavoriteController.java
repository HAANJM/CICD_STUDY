package com.ssafy.ssafitlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.dto.Favorite;
import com.ssafy.ssafitlog.model.service.FavoriteService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService likeService;
	
	@ApiOperation(value="좋아요 등록", notes = "좋아요 등록")
	@GetMapping("")
	public ResponseEntity<?> searchLike(Favorite favorite) {
		if (likeService.searchFavorite(favorite)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="좋아요 등록", notes = "좋아요 등록")
	@PostMapping("")
	public ResponseEntity<?> registLike(Favorite favorite) {
		if (likeService.registFavorite(favorite)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="좋아요 해제", notes = "좋아요 해제")
	@DeleteMapping("")
	public ResponseEntity<?> deleteLike(@RequestBody Favorite favorite) {
		if (likeService.deleteFavorite(favorite)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
