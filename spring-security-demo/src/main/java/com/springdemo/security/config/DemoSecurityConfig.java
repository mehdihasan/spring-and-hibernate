package com.springdemo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//.anyRequest().authenticated() // hide everything behind authentication 
				.antMatchers("/").permitAll()  // allow public access to home page
		        .antMatchers("/employees").hasRole("EMPLOYEE")
		        .antMatchers("/leaders/**").hasRole("MANAGER")
		        .antMatchers("/systems/**").hasRole("ADMIN")
			.and()
				.formLogin()
					.loginPage(Url.LOGIN)
					.loginProcessingUrl(Url.LOGIN_PROCESSING)
					.permitAll()
			.and()
				.logout()
					.logoutSuccessUrl("/")  // after logout then redirect to landing page (root)
					.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("John").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("Mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("Susan").password("test123").roles("EMPLOYEE", "ADMIN"));
	}
}
