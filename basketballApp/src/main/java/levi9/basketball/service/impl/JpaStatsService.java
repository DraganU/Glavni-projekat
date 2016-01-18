package levi9.basketball.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levi9.basketball.model.Stats;
import levi9.basketball.repository.StatsRepository;
import levi9.basketball.service.StatsService;

@Transactional
@Service
public class JpaStatsService implements StatsService {

	@Autowired
	StatsRepository statsRepository;
	
	@Override
	public Stats save(Stats stats) {
		return statsRepository.save(stats);
	}

	@Override
	public Stats findOne(Long id) {
		return statsRepository.findById(id);
	}

}
