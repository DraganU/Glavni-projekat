package levi9.basketball.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import levi9.basketball.service.impl.BasketballDataProvider;

@RestController
@RequestMapping("/api/load")
public class ApiLoadController {

	@Autowired
	private BasketballDataProvider basketballDataProvider;
	
	

	public Object getPlayers() {
		return basketballDataProvider.getPlayers();
	}

	public Object getStats() {
		return basketballDataProvider.getStats();
	}

	@RequestMapping(value = "/api/players", method = RequestMethod.GET)
	public ResponseEntity<Object> getPlay() {

		Object ob = getPlayers();
		return new ResponseEntity<Object>(ob, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getStat() throws JsonParseException, JsonMappingException, IOException {

		
		
		return new ResponseEntity<Object>(basketballDataProvider.parseJson() , HttpStatus.OK);
	}
	
	
}
