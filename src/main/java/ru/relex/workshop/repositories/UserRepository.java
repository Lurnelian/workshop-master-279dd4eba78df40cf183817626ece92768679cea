package ru.relex.workshop.repositories;

import java.util.List;

import ru.relex.workshop.domain.User;

public interface UserRepository {

	int createUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	int updateUser(User user);
	
	User getUserByEmail(String email);

}
