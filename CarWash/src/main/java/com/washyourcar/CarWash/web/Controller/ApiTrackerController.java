package com.washyourcar.CarWash.web.Controller;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.washyourcar.CarWash.Model.Tracker;
import com.washyourcar.CarWash.Model.Wash;
import com.washyourcar.CarWash.service.TrackerService;
import com.washyourcar.CarWash.service.WashService;


@RestController
@RequestMapping ("api/tracker")
public class ApiTrackerController {

	@Autowired
	private TrackerService trackerService;
	
	@Autowired
	private WashService washService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Tracker>> getTrackers() {

		ArrayList<Tracker> wash = trackerService.findAll();
		return new ResponseEntity<>(wash, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Tracker> addTracker(@RequestBody Tracker tracker) {
		
		Tracker tracker2 = new Tracker();
		Wash wash = washService.findOne(tracker.getWash().getId());
		tracker2.setWash(wash);
		tracker2.setDate(new Date());

		Tracker trackerPersisted = trackerService.save(tracker2);
		return new ResponseEntity<>(trackerPersisted, HttpStatus.CREATED);
	}
}
