package levi9.basketball.service;

import org.springframework.data.domain.Page;

import levi9.basketball.model.Player;


public interface PlayerService {

	Player save (Player player);
	Player findOne(String id);
	Page<Player> findAll(int page, int pageSize);
}
