package levi9.basketball.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import levi9.basketball.model.Player;
import levi9.basketball.service.PlayerService;

@RestController
@RequestMapping("api/players")
public class ApiPlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Player>> getPlayers(
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "pageSize", required = false ) int pageSize) {

		List<Player> players = new ArrayList<>();

		int totalPages = 0;
		long totalElements = 0;

		Page<Player> playerPage = playerService.findAll(page, pageSize);
		for (Player a : playerPage) {
			players.add(new Player(a));
		}
		totalPages = playerPage.getTotalPages();
		totalElements = playerPage.getTotalElements();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", "" + totalPages);
		httpHeaders.add("total-elements", "" + totalElements);
		return new ResponseEntity<>(players, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Player> getPlayer (@PathVariable String id) {
		Player play = playerService.findOne(id);
		if (play == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Player(play), HttpStatus.OK);
	}

	
	

}
