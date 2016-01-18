package levi9.basketball.service;

import java.util.Collection;
import java.util.Optional;

import levi.basketball.dto.UserCreateForm;
import levi9.basketball.model.User;

public interface UserService {

	Optional<User> getUserById(long id);
    Optional<User> getUserByEmail(String email);
    Collection<User> getAllUsers();
    User create(UserCreateForm form);
}
