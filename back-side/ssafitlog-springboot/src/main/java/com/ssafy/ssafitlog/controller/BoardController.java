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

import com.ssafy.ssafitlog.model.dto.Board;
import com.ssafy.ssafitlog.model.dto.SearchCondition;
import com.ssafy.ssafitlog.model.service.BoardService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value="게시글 작성", notes = "게시글 작성")
	@PostMapping("")
	public ResponseEntity<?> registBoard(@RequestBody Board board) {
		if (boardService.registBoard(board)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="게시글 조회", notes = "검색 조건도 넣으면 같이 가져옴")
	@GetMapping("")
	public ResponseEntity<?> searchBoardByCondition(@RequestBody SearchCondition condition) {
		List<Board> result = boardService.searchBoardByCondition(condition);
		return new ResponseEntity<List<Board>>(result, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="스트릭 정보 가져오기", notes = "스트릭 선택시 그에 따른 게시글 다 긁어오기") // 작업해야함
	@GetMapping("/date")
	public ResponseEntity<?> searchBoardByDate(@RequestBody SearchCondition condition) {
		List<Board> result = boardService.searchBoardByDate(condition);
		return new ResponseEntity<List<Board>>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value="게시글 상세정보 가져오기", notes = "게시글 상세정보 가져오기") // 작업해야함
	@GetMapping("/{boardNumber}")
	public ResponseEntity<?> searchBoardDetail(@PathVariable int boardNumber) {
		Board result = boardService.searchBoardDetail(boardNumber);
		return new ResponseEntity<Board>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value="게시글 수정", notes = "게시글 수정")
	@PutMapping("")
	public ResponseEntity<?> modifyBoard(@RequestBody Board board) {
		if (boardService.modifyBoard(board)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="게시글  삭제", notes = "게시글 삭제")
	@DeleteMapping("")
	public ResponseEntity<?> deleteBoard(@RequestBody Board board) {
		if (boardService.deleteBoard(board)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
