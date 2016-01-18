package levi9.basketball.service;

import org.springframework.data.domain.Page;

import levi9.basketball.model.DreamTeam;
import levi9.basketball.model.Team;

public interface TeamService {

		Team save (Team team);
		DreamTeam saveDreamTeam (DreamTeam dt);
		DreamTeam findOne(Long id);
		Page<DreamTeam> findAll(int page, int pageSize);
		
}
