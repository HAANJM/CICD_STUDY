package com.ssafy.ssafitlog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafitlog.model.dao.BoardDao;
import com.ssafy.ssafitlog.model.dao.FavoriteDao;
import com.ssafy.ssafitlog.model.dto.Favorite;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	private FavoriteDao favoriteDao;

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean registFavorite(Favorite favorite) {
		if (boardDao.upFavoriteCount(favorite) != 1) {
			return false;
		}
		return favoriteDao.insertFavorite(favorite) == 1;
	}

	@Override
	public boolean deleteFavorite(Favorite favorite) {
		if (boardDao.downFavoriteCount(favorite) != 1) {
			return false;
		}
		return favoriteDao.deleteFavorite(favorite) == 1;
	}
	
	@Override
	public boolean searchFavorite(Favorite favorite) {
		if (favoriteDao.selectFavorite(favorite) == 1) {
			return true;
		}
		return false;
	}
}
