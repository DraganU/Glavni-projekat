package levi9.basketball.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import levi9.basketball.model.DreamTeam;
import levi9.basketball.service.TeamService;

@RestController
@RequestMapping("api/teams")
public class ApiTeamController {

	
	@Autowired
	private TeamService teamService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DreamTeam>> getDreamTeams(
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "pageSize", required = false ) int pageSize) {

		List<DreamTeam> teams = new ArrayList<>();

		int totalPages = 0;
		long totalElements = 0;

		Page<DreamTeam> teamPage = teamService.findAll(page, pageSize);
		for (DreamTeam a : teamPage) {
			teams.add(new DreamTeam(a));
		}
		totalPages = teamPage.getTotalPages();
		totalElements = teamPage.getTotalElements();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", "" + totalPages);
		httpHeaders.add("total-elements", "" + totalElements);
		return new ResponseEntity<>(teams, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DreamTeam> getDreamTeam (@PathVariable Long id) {
		DreamTeam dt = teamService.findOne(id);
		if (dt == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new DreamTeam(dt), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DreamTeam> addDreamTeam(@RequestBody DreamTeam dreamTeam) {

		DreamTeam dt = teamService.saveDreamTeam(dreamTeam);	

		return new ResponseEntity<>(new DreamTeam(dt), HttpStatus.CREATED);
	}
	
}
