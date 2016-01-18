package levi9.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import levi9.basketball.model.Stats;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {

	Stats findById (Long id);
}
