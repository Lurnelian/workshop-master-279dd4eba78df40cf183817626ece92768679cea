package ru.relex.workshop.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.relex.workshop.domain.Role;
import ru.relex.workshop.domain.User;
import ru.relex.workshop.repositories.RoleRepository;
import ru.relex.workshop.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getUserByEmail(username);
		
		List<Role> roles = roleRepository.getAllRoles();
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
				username, user.getPassword(), authorities);
		
		return userDetails;
	}

}
