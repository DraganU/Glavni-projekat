package com.washyourcar.CarWash.service.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washyourcar.CarWash.Model.Tracker;
import com.washyourcar.CarWash.repository.TrackerRepository;
import com.washyourcar.CarWash.service.TrackerService;

@Service
@Transactional
public class JpaTrackerService implements TrackerService {

	@Autowired
	private TrackerRepository trackerRepository;

	@Override
	public ArrayList<Tracker> findAll() {
		return trackerRepository.findAll();
	}

	@Override
	public Tracker save(Tracker tracker) {
		return trackerRepository.save(tracker);
	}
}
