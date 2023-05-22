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

import com.ssafy.ssafitlog.model.dto.Exp;
import com.ssafy.ssafitlog.model.service.ExpService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/exp")
public class ExpController {
	
	@Autowired
	private ExpService expService;
	
	@ApiOperation(value="Exp 객체 등록", notes = "login할 때 요청(필요한가?)")
	@PostMapping("")
	public ResponseEntity<?> registExp(@RequestBody Exp exp) {
		if (expService.registExp(exp)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="경험치 테이블 가져오기", notes = "그래프용")
	@GetMapping("")
	public ResponseEntity<?> searchAllExp(@PathVariable String userId) {
		List<Exp> result = expService.searchAllExp(userId);
		return new ResponseEntity<List<Exp>>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value="경험치 객체 제거", notes = "게시글 0, 댓글 0, 로그아웃할때인데 필요할까? 구현할 수 있을까?")
	@DeleteMapping("")
	public ResponseEntity<?> deleteExp(@PathVariable String regDate) {
		if (expService.deleteExp(regDate)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
