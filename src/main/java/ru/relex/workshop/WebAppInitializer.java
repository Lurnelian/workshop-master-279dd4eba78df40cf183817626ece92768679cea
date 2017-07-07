package ru.relex.workshop;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ru.relex.workshop.config.WorkshopConfig;
import ru.relex.workshop.config.WorkshopWebConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WorkshopConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WorkshopWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
