package levi9.basketball.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import levi9.basketball.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	Page<Player> findAll(Pageable pageable);
	Player findById (String id);
}
