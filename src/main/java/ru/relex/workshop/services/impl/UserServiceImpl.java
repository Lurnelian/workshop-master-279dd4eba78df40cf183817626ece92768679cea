package ru.relex.workshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.relex.workshop.domain.User;
import ru.relex.workshop.repositories.UserRepository;
import ru.relex.workshop.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public int createUser(User user) {
		return userRepository.createUser(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public int updateUser(User user) {
		return userRepository.updateUser(user);
	}

}
