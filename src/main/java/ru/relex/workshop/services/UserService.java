package ru.relex.workshop.services;

import java.util.List;

import ru.relex.workshop.domain.User;

public interface UserService {

	int createUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	int updateUser(User user);
	
}
