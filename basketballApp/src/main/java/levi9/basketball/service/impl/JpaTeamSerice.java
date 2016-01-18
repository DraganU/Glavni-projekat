package levi9.basketball.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levi9.basketball.model.DreamTeam;
import levi9.basketball.model.Team;
import levi9.basketball.repository.DreamTeamRepository;
import levi9.basketball.repository.TeamRepository;
import levi9.basketball.service.TeamService;

@Transactional
@Service
public class JpaTeamSerice implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	DreamTeamRepository dreamTeamRepository;
	
	@Override
	public Team save(Team team) {
		return teamRepository.save(team);
	}
	
	@Override
	public DreamTeam saveDreamTeam(DreamTeam dteam) {
		return dreamTeamRepository.save(dteam);	
	}

	@Override
	public DreamTeam findOne(Long id) {
		return dreamTeamRepository.findOne(id);
	}

	@Override
	public Page<DreamTeam> findAll(int page, int pageSize) {
		return dreamTeamRepository.findAll(new PageRequest(page, pageSize));
	}

}
