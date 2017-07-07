package ru.relex.workshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.relex.workshop.domain.User;
import ru.relex.workshop.dto.UserDto;
import ru.relex.workshop.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		int affected = userService.createUser(user.toDomain());
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDto> userDtos = new ArrayList<>();
		for (User user : users) {
			userDtos.add(new UserDto(user));
		}
		return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
	}

}
