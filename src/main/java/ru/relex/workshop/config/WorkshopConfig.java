package ru.relex.workshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.relex.workshop.controllers.WorkshopControllersConfig;
import ru.relex.workshop.repositories.impl.RepositoriesConfig;
import ru.relex.workshop.security.SecurityConfig;
import ru.relex.workshop.services.impl.ServicesConfig;

@Configuration
@ComponentScan(basePackageClasses = WorkshopConfig.class)
@Import({ WorkshopControllersConfig.class, RepositoriesConfig.class, ServicesConfig.class, SecurityConfig.class })
public class WorkshopConfig {

}
