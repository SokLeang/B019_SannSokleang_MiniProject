package com.hrd.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MainConfiguration extends WebMvcConfigurerAdapter {

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Front End
				registry.addViewController("/about").setViewName("/about");
				registry.addViewController("/contact").setViewName("/contact");
				registry.addViewController("/home").setViewName("/home");
				registry.addViewController("/").setViewName("/home");
		
		registry.addViewController("/admin/").setViewName("/admin/dashboard");
		registry.addViewController("/admin/dashboard").setViewName("/admin/dashboard");
		registry.addViewController("/admin/user").setViewName("/admin/user");
		registry.addViewController("/admin/user-cu").setViewName("/admin/user-cu");
		registry.addViewController("/admin/role-list").setViewName("/admin/role-list");
		registry.addViewController("/admin/role-cu").setViewName("/admin/role-cu");
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * Static Resources store in the project
		 */
		registry.addResourceHandler("/resources/**")
					.addResourceLocations("classpath:/static/");
		/*
		 * Static Resources store outside the project
		 */
		registry.addResourceHandler("/files/**")
					.addResourceLocations("file:/opt/FILES_MANAGEMENT/images/");
	}
}
