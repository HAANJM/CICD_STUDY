package com.ssafy.ssafitlog.model.service;

import com.ssafy.ssafitlog.model.dto.Favorite;

public interface FavoriteService {
	boolean registFavorite(Favorite favorite);
	
	boolean deleteFavorite(Favorite favorite);
}
