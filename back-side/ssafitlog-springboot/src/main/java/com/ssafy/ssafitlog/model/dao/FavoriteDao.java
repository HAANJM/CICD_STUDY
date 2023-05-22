package com.ssafy.ssafitlog.model.dao;

import com.ssafy.ssafitlog.model.dto.Favorite;

public interface FavoriteDao {
	int insertFavorite(Favorite favorite);
	
	int deleteFavorite(Favorite favorite);
}
