package levi9.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import levi9.basketball.model.DreamTeam;

@Repository
public interface DreamTeamRepository extends JpaRepository<DreamTeam, Long> {

	
	
}
