package ru.relex.workshop.repositories.impl;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.relex.workshop.domain.User;
import ru.relex.workshop.repositories.UserRepository;
import sun.security.util.Password;

@Repository
@PropertySource("classpath:ru/relex/workshop/queries/users.xml")
public class UserRepositoryImpl implements UserRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	private static final String CREATE_USER_QUERY = "createUser";
	private static final String GET_USER_BY_ID_QUERY = "getUserById";
	private static final String GET_USER_BY_EMAIL_QUERY = "getUserByEmail";
	private static final String GET_ALL_USERS_QUERY = "getAllUsers";
	private static final String UPDATE_USER_QUERY = "updateUser";
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserRepositoryImpl(DataSource datasource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}

	@Override
	public int createUser(User user) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", user.getId())
				.addValue("email", user.getEmail())
				.addValue("password", passwordEncoder.encode(user.getPassword()))
				.addValue("description", user.getDescription());
		return namedParameterJdbcTemplate.update(environment.getProperty(CREATE_USER_QUERY), sqlParameterSource);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(environment.getProperty(GET_USER_BY_ID_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.query(environment.getProperty(GET_ALL_USERS_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public int updateUser(User user) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", user.getId())
				.addValue("email", user.getEmail())
				.addValue("password", passwordEncoder.encode(user.getPassword()))
				.addValue("description", user.getDescription());
		return namedParameterJdbcTemplate.update(environment.getProperty(UPDATE_USER_QUERY), sqlParameterSource);
	}

	@Override
	public User getUserByEmail(String email) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("email", email);
		return namedParameterJdbcTemplate.queryForObject(environment.getProperty(GET_USER_BY_EMAIL_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(User.class));
	}
	
	
	
}
