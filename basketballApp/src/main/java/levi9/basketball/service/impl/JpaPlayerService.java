package levi9.basketball.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levi9.basketball.model.Player;
import levi9.basketball.repository.PlayerRepository;
import levi9.basketball.service.PlayerService;


@Transactional
@Service
public class JpaPlayerService implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public Player save(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player findOne(String id) {
		return playerRepository.findById(id);
	}

	@Override
	public Page<Player> findAll(int page, int pageSize) {
		return playerRepository.findAll(new PageRequest(page, pageSize));
	}

}
