package levi9.basketball.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import levi.basketball.dto.UserCreateForm;
import levi9.basketball.model.User;
import levi9.basketball.repository.UserRepository;
import levi9.basketball.service.UserService;

public class UserServiceImpl implements UserService {

	 private final UserRepository userRepository;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @Override
	    public Optional<User> getUserById(long id) {
	        return Optional.ofNullable(userRepository.findOne(id));
	    }

	    @Override
	    public Optional<User> getUserByEmail(String email) {
	        return userRepository.findOneByEmail(email);
	    }

	    @Override
	    public Collection<User> getAllUsers() {
	        return userRepository.findAll(new Sort("email"));
	    }

	    @Override
	    public User create(UserCreateForm form) {
	        User user = new User();
	        user.setEmail(form.getEmail());
	        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
	        user.setRole(form.getRole());
	        return userRepository.save(user);
	    }

}
