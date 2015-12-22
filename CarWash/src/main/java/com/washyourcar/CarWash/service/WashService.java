package com.washyourcar.CarWash.service;

import java.util.ArrayList;

import com.washyourcar.CarWash.Model.Wash;

public interface WashService {

	Wash findOne(Long id);
	ArrayList<Wash> findAll();
	Wash save(Wash wash);
	void remove(Long id) throws IllegalArgumentException;
	
}
