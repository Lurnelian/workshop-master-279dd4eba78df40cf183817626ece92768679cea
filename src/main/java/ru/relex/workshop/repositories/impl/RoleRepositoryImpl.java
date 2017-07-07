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
import org.springframework.stereotype.Repository;

import ru.relex.workshop.domain.Role;
import ru.relex.workshop.repositories.RoleRepository;

@Repository
@PropertySource("classpath:ru/relex/workshop/queries/roles.xml")
public class RoleRepositoryImpl implements RoleRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleRepositoryImpl.class);
	
	private static final String GET_ALL_ROLES_QUERY = "getAllRoles";
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	public RoleRepositoryImpl(DataSource datasource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	@Override
	public List<Role> getAllRoles() {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.query(environment.getProperty(GET_ALL_ROLES_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(Role.class));
	}

}
