package com.homion.chef;

import com.homion.chef.filters.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.homion.chef.*")
public class ChefApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChefApplication.class, args);
	}

	//to restrict spring boot from automatically adding jwt filter to the filter chain, which applies it for all incoming req
	// , as we don't want jwt token to be verified for some request (for eg /login)
	@Bean
	public RegistrationBean jwtAuthFilterRegister(JwtAuthenticationFilter filter) {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
		registrationBean.addUrlPatterns("*/login");
		registrationBean.setEnabled(false);
		return registrationBean;
	}

}
