package jwd.wafepa.web.controller;

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

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.User;
import jwd.wafepa.service.UserService;
import jwd.wafepa.web.dto.ActivityDTO;
import jwd.wafepa.web.dto.UserDTO;

@RestController
@RequestMapping("api/users")
public class ApiUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getUsers(
			@RequestParam(value = "email", required = false) String name,
			@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize){

		List<UserDTO> users = new ArrayList<>();
		int totalPages = 0;
		long totalElements = 0;
		if (name == null) {
			Page<User> usersPage = userService.findAll(page);
			for (User a : userService.findAll(page)) {
				users.add(new UserDTO(a));
			}
			totalPages = usersPage.getTotalPages();
			totalElements = usersPage.getTotalElements();
		} else {
			for (User a : userService.findByEmail(name, page)) {
				users.add(new UserDTO(a));
			}
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", "" + totalPages);
		httpHeaders.add("total-elements", "" + totalElements);
		return new ResponseEntity<>(users, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user != null) {
			userService.remove(id);
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		User userPersisted = userService.save(user);
		return new ResponseEntity<>(new UserDTO(userPersisted), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<UserDTO> editUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
		User user = userService.findOne(id);
		if (user != null) {
			if (id != userDto.getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
			user.setFirstname(userDto.getFirstname());
			user.setLastname(userDto.getLastname());
			User persistedUser = userService.save(user);
			return new ResponseEntity<>(new UserDTO(persistedUser), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
