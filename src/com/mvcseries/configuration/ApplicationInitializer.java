package com.mvcseries.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Provides configuration for dispatcher servlet which usually configured in
 * web.xml file.
 * 
 * @author arnab
 *
 */
public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Dispatcher servlet
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfig.class);
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("mvc",
				new DispatcherServlet(context));
		servletRegistration.setLoadOnStartup(1);// Default load on startup is -1, denotes lazy loading
		servletRegistration.addMapping("/");
	}

}
