package jwd.wafepa.service;



import org.springframework.data.domain.Page;

import jwd.wafepa.model.User;

public interface UserService {

	User findOne(Long id);
	Page<User> findAll(int page);
	User save(User user);
	void remove(Long id) throws IllegalArgumentException;
	Page<User> findByEmail(String string, int page);
}
