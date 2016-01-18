package levi9.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import levi9.basketball.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
