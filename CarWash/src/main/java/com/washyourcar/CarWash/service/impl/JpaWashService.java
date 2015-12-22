package com.washyourcar.CarWash.service.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washyourcar.CarWash.Model.Wash;
import com.washyourcar.CarWash.repository.WashRepository;
import com.washyourcar.CarWash.service.WashService;

@Service
@Transactional
public class JpaWashService implements WashService {

	@Autowired
	private WashRepository washRepository;

	@Override
	public ArrayList<Wash> findAll() {
		return washRepository.findAll();
	}

	@Override
	public Wash save(Wash wash) {
		return washRepository.save(wash);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Wash wash = washRepository.findOne(id);
		if (wash == null) {
			throw new IllegalArgumentException("Tried to remove nonexistant wash id:" + id);
		}
		washRepository.delete(wash);
	}

	@Override
	public Wash findOne(Long id) {
		return washRepository.findOne(id);
	}

}
