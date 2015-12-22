package com.washyourcar.CarWash.web.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.washyourcar.CarWash.Model.Wash;
import com.washyourcar.CarWash.service.WashService;

@RestController
@RequestMapping("api/washes")
public class ApiWashController {

	@Autowired
	private WashService washService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Wash>> getWashes() {

		ArrayList<Wash> wash = washService.findAll();

		return new ResponseEntity<>(wash, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Wash> getUser(@PathVariable Long id) {
		Wash wash2 = washService.findOne(id);
		if (wash2 == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(wash2, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Wash> addWash(@RequestBody Wash wash) {

		Wash washPersisted = washService.save(wash);

		return new ResponseEntity<>(washPersisted, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Wash> editWash(@PathVariable Long id, @RequestBody Wash wash) {

		Wash wash2 = washService.findOne(id);
		if (wash2 != null) {
			if (id != wash.getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Wash persistedWash = washService.save(wash);
			return new ResponseEntity<>(persistedWash, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
