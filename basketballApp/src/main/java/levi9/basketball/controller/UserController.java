package levi9.basketball.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import levi.basketball.dto.UserCreateForm;
import levi9.basketball.service.UserService;
import levi9.basketball.service.impl.UserCreateFormValidator;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	/*private final UserService userService;
	private final UserCreateFormValidator userCreateFormValidator;
	
	@Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }*/
	
	/*@InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<UserCreateForm>> getUsersPage() {
        // PROMENITI
		List <UserCreateForm> usf = new ArrayList ();
		
		
		return new ResponseEntity<>(usf, HttpStatus.OK);
    }*/
	
	
	
}
