package ru.relex.workshop.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackageClasses = DatasourceConfig.class)
@PropertySource("classpath:ru/relex/workshop/db.properties")
public class DatasourceConfig {
	
	@Autowired
	private Environment environment;

	@Bean
	public DataSource datasource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(environment.getProperty("driver"));
		datasource.setUrl(environment.getProperty("dbUrl"));
		datasource.setUsername(environment.getProperty("username1"));
		datasource.setPassword(environment.getProperty("password"));
		return datasource;
	}
	
}
