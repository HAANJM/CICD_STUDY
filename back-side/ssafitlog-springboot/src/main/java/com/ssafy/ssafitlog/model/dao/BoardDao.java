package com.ssafy.ssafitlog.model.dao;

import java.util.List;

import com.ssafy.ssafitlog.model.dto.Board;
import com.ssafy.ssafitlog.model.dto.Favorite;
import com.ssafy.ssafitlog.model.dto.ReviewContainBoard;
import com.ssafy.ssafitlog.model.dto.SearchCondition;

public interface BoardDao {
	int insertBoard(Board board);
	
	int updateBoard(Board board);
	
	int deleteBoard(int boardNumber);
	
	List<Board> selectBoardByFavorite(SearchCondition condition);
	
	List<Board> selectBoardByFollow(SearchCondition condition);
	
	List<Board> selectBoardByRecent(SearchCondition condition);
	
	List<Board> selectBoardByHot(SearchCondition condition);
	
	List<Board> selectBoardByWord(SearchCondition condition);
	
	List<Board> selectBoardByDate(SearchCondition condition);

	Board selectBoard(int boardNumber);
	
	int updateScoreCount(ReviewContainBoard reviewContainBoard);
	
	int upFavoriteCount(Favorite favorite);
	
	int downFavoriteCount(Favorite favorite);
}