package com.ssafy.ssafitlog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafitlog.model.dao.BoardDao;
import com.ssafy.ssafitlog.model.dto.Board;
import com.ssafy.ssafitlog.model.dto.Favorite;
import com.ssafy.ssafitlog.model.dto.ReviewContainBoard;
import com.ssafy.ssafitlog.model.dto.SearchCondition;
import com.ssafy.ssafitlog.model.dto.StricExpDiff;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Autowired
	private ExpService expService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean registBoard(Board board) {
		// board 등록
		System.out.println("000");
		boardDao.insertBoard(board);
		System.out.println("111");
		// 현 mybatis 버전으론 select하면서 두 개의 속성을 받아올 수 없으므로 select 요청을 한 번 한다. (regDate와 boardNumber가 필요)
		Board newBoard = searchBoardDetail(board.getBoardNumber());
		
		System.out.println("222");
		// 점수 반영 작업을 위한 객체 reviewContatinBoard 생성 및 초기화
		ReviewContainBoard reviewContainBoard = new ReviewContainBoard();
		reviewContainBoard.setBoardNumber(newBoard.getBoardNumber());
		reviewContainBoard.setBoardRegDate(newBoard.getRegDate());
		reviewContainBoard.setBoardUserId(newBoard.getUserId());
		reviewContainBoard.setReviewScore(1); // 게시글 등록 점수로 1 주기
		
		System.out.println("333");
		// 게시글 등록 날짜에 있는 모든 게시글 점수 합 가져오기 : reviewContainBoard의 scoreCountSum에 져장됨
		modifyScoreCount(reviewContainBoard);
		
		System.out.println("444");
		// scoreCountSum을 stricExp로 변환
		int stricExp = expService.convertScoreToExp(reviewContainBoard.getScoreCountSum());
		
		System.out.println("555");
		// user의 totalExp에 반영할 strixExpDiff를 만든다.
		StricExpDiff exp = new StricExpDiff();
		exp.setUserId(reviewContainBoard.getBoardUserId());
		exp.setRegDate(reviewContainBoard.getBoardRegDate());
		exp.setStricExp(stricExp);
		expService.modifyStricExp(exp);
		
		System.out.println("666");
		// user의 totalExp에 요청
		userService.modifyStricExp(exp);
		System.out.println("777");
		return true;
	}
	
	public List<Board> searchBoardByCondition(SearchCondition condition) {
		switch (condition.getType()) {
		case "hot" :
			return searchBoardByHot(condition);
		case "recent" :
			return searchBoardByRecent(condition);
		case "favorite" :
			return searchBoardByFavorite(condition);
		case "word" :
			return searchBoardByWord(condition);
		default :
			return searchBoardByFollow(condition);
		}
	}
	
	@Override
	public List<Board> searchBoardByFavorite(SearchCondition condition) {
		return boardDao.selectBoardByFavorite(condition);
	}

	@Override
	public List<Board> searchBoardByFollow(SearchCondition condition) {
		return boardDao.selectBoardByFollow(condition);
	}

	@Override
	public List<Board> searchBoardByRecent(SearchCondition condition) {
		return boardDao.selectBoardByRecent(condition);
	}

	@Override
	public List<Board> searchBoardByHot(SearchCondition condition) {
		return boardDao.selectBoardByHot(condition);
	}

	@Override
	public List<Board> searchBoardByWord(SearchCondition condition) {
		return boardDao.selectBoardByWord(condition);
	}

	@Override
	public List<Board> searchBoardByDate(SearchCondition condition) {
		return boardDao.selectBoardByDate(condition);
	}

	@Override
	public Board searchBoardDetail(int boardNumber) {
		return boardDao.selectBoard(boardNumber);
	}
	
	@Override
	public boolean modifyBoard(Board board) {
		return boardDao.updateBoard(board) == 1;
	}
	
	@Override
	public boolean deleteBoard(Board board) {
		// board 제거
	
		
		// 점수 반영 작업을 위한 객체 reviewContatinBoard 생성 및 초기화
		ReviewContainBoard reviewContainBoard = new ReviewContainBoard();
		reviewContainBoard.setBoardNumber(board.getBoardNumber());
		reviewContainBoard.setBoardRegDate(board.getRegDate());
		reviewContainBoard.setBoardUserId(board.getUserId());
		
		// 게시글 등록 날짜에 있는 모든 게시글 점수 합 가져오기 : reviewContainBoard의 scoreCountSum에 져장됨
		int temp = board.getScoreCount();
		board.setScoreCount(0);
		modifyScoreCount(reviewContainBoard); // 이거 보드 지운 상태인데 쿼리문 잘 작동하는지 봐야함. 작동안하면 다르게 접근해야함(메서드 하나 더 만들던가)
		
		// scoreCountSum을 stricExp로 변환
		if (reviewContainBoard.getScoreCountSum() == null) {
			reviewContainBoard.setScoreCountSum(0);
		}
		int stricExp = expService.convertScoreToExp(reviewContainBoard.getScoreCountSum()) 
				- temp;
		
		// user의 totalExp에 반영할 strixExpDiff를 만든다.
		StricExpDiff exp = new StricExpDiff();
		exp.setUserId(reviewContainBoard.getBoardUserId());
		exp.setRegDate(reviewContainBoard.getBoardRegDate());
		exp.setStricExp(stricExp);
		expService.modifyStricExp(exp);
		
		boardDao.deleteBoard(board.getBoardNumber());
		// user의 totalExp에 요청
		userService.modifyStricExp(exp);
		return true;
	}


	@Override
	public boolean modifyScoreCount(ReviewContainBoard reviewContainBoard) {
		return boardDao.updateScoreCount(reviewContainBoard) == 1;
	}

	@Override
	public boolean upFavoriteCount(Favorite favorite) {
		return boardDao.upFavoriteCount(favorite) == 1;
	}

	@Override
	public boolean downFavoriteCount(Favorite favorite) {
		return boardDao.downFavoriteCount(favorite) == 1;
	}
}
