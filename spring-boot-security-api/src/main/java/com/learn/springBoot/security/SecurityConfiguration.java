package com.learn.springBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author rajes
 * date    Jan 19, 201712:58:53 AM
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccountAuthenticationProvider accountAuthenticationProvider;
	
	@Bean // Bean annotation recognizes teh method response and registers with the spring
	public BCryptPasswordEncoder passwordEncoder()
	{
		return  new BCryptPasswordEncoder();
	}
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) {
 		auth.authenticationProvider(accountAuthenticationProvider);
 				
 	}

	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests().antMatchers("/api/**").hasRole("USER")
 	    .antMatchers("/health").hasRole("SYSADMIN")
 				//.and()
 				//.httpBasic()
 				// spring security wil automatially extract the credentials from header automatically
 				//.and()
 				//.sessionManagement()
 				//.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
 				.and().formLogin();
 		
 	
 				// by default the sprng security caches all teh sussefful authentication request in the http session. we are disabling it 
 	}
 }


