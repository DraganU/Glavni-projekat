package levi9.basketball.service;

import levi9.basketball.model.Stats;

public interface StatsService {

	Stats findOne(Long id);
	Stats save (Stats stats);
}
