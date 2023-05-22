package com.ssafy.ssafitlog.model.service;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Board;
import com.ssafy.ssafitlog.model.dto.ReviewContainBoard;
import com.ssafy.ssafitlog.model.dto.SearchCondition;

public interface BoardService {
	
	boolean registBoard(Board board);
	
	boolean modifyBoard(Board board);
	
	boolean deleteBoard(Board board);
	
	List<Board> searchBoardByLike(SearchCondition condition);
	
	List<Board> searchBoardByFollow(SearchCondition condition);
	
	List<Board> searchBoardByRecent(SearchCondition condition);
	
	List<Board> searchBoardByHot(SearchCondition condition);
	
	List<Board> searchBoardByCondition(SearchCondition condition);
	
	List<Board> searchBoardByWord(SearchCondition condition);
	
	List<Board> searchBoardByDate(SearchCondition condition);
	
	Board searchBoardDetail(int boardNumber);
	
	boolean modifyScoreCount(ReviewContainBoard reviewContainBoard);
}
