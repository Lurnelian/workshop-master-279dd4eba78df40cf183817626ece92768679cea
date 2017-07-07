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

import ru.relex.workshop.domain.Advertisement;
import ru.relex.workshop.repositories.AdvertisementRepository;

@Repository
@PropertySource("classpath:ru/relex/workshop/queries/advertisements.xml")
public class AdvertisementRepositoryImpl implements AdvertisementRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleRepositoryImpl.class);
	
	private static final String GET_ALL_ADVERTISEMENTS_QUERY = "getAllAdvertisements";
	private static final String GET_ADVERTISEMENT_BY_ID_QUERY = "getAdvertisementById";
	private static final String CREATE_ADVERTISEMENT_QUERY = "createAdvertisement";
	private static final String UPDATE_ADVERTISEMENT_QUERY = "updateAdvertisement";
	private static final String DELETE_ADVERTISEMENT_QUERY = "deleteAdvertisement";
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	public AdvertisementRepositoryImpl(DataSource datasource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}

	@Override
	public int createAdvertisement(Advertisement advertisement) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("name", advertisement.getName())
				.addValue("description", advertisement.getDescription())
				.addValue("price", advertisement.getPrice())
				.addValue("address",advertisement.getAddress())
				.addValue("phone",advertisement.getPhone());
		return namedParameterJdbcTemplate.update(environment.getProperty(CREATE_ADVERTISEMENT_QUERY), sqlParameterSource);
	}

	@Override
	public int deleteAdvertisement(Long id) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", id);
		return namedParameterJdbcTemplate.update(environment.getProperty(DELETE_ADVERTISEMENT_QUERY), sqlParameterSource);
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.query(environment.getProperty(GET_ALL_ADVERTISEMENTS_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(Advertisement.class));
	}

	@Override
	public int updateAdvertisement(Advertisement advertisement) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("name", advertisement.getName())
				.addValue("description", advertisement.getDescription())
				.addValue("price", advertisement.getPrice())
				.addValue("id", advertisement.getId())
				.addValue("address",advertisement.getAddress())
				.addValue("phone",advertisement.getPhone());
		return namedParameterJdbcTemplate.update(environment.getProperty(UPDATE_ADVERTISEMENT_QUERY), sqlParameterSource);
	}

	@Override
	public Advertisement getAdvertisementById(Long id) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(environment.getProperty(GET_ADVERTISEMENT_BY_ID_QUERY),
				sqlParameterSource, BeanPropertyRowMapper.newInstance(Advertisement.class));
	}

}
