package jwd.wafepa.service.impl;

import java.util.List;

import jwd.wafepa.model.User;
import jwd.wafepa.repository.UserRepository;
import jwd.wafepa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class JpaUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Page <User> findAll(int page) {
		return userRepository.findAll(new PageRequest(page, 5));
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		userRepository.delete(id);
	}
	@Override
	public Page<User> findByEmail (String string, int page) {
		return userRepository.findByEmailLike(("%" + string + "%"),(new PageRequest(page,5)));
	}
}
