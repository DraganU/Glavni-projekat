package com.washyourcar.CarWash.service;

import java.util.ArrayList;

import com.washyourcar.CarWash.Model.Tracker;


public interface TrackerService {
	ArrayList<Tracker> findAll();
	Tracker save (Tracker tracker);
}
