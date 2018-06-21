/**
 * Jan 8, 2017
 * rajes
 */
package com.learn.springBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rajes
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
								//.antMatchers("/testTopics").permitAll()
								.antMatchers(HttpMethod.GET, "/topics/*").hasRole("USER")
								.antMatchers(HttpMethod.GET, "/testTopics").hasRole("DELETEROLE")
								.and()
								.formLogin();
								//.loginPage("/login")
								//.failureUrl("/login-error");
		http.csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
									.withUser("rajesh").password("Changeme").roles("USER")
									.and()
									.withUser("daakshya").password("Changeme").roles("USER","DELETEROLE");
								
									
		          
	}

}
