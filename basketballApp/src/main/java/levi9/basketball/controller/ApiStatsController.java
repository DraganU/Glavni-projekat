package levi9.basketball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import levi9.basketball.model.Stats;
import levi9.basketball.service.StatsService;

@RestController
@RequestMapping("api/stats")
public class ApiStatsController {

	@Autowired
	private StatsService statsService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Stats> getStats (@PathVariable Long id) {
		Stats stats = statsService.findOne(id);
		if (stats == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Stats(stats), HttpStatus.OK);
	}
}
