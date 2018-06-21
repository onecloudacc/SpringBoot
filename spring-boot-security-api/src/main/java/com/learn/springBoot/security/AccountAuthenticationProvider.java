package com.learn.springBoot.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author rajes
 * date    Jan 19, 201712:28:24 AM
 *
 *retrieveUser()-->When the user types the username and password, String username holds teh username entered by the customer, the below token object holds the password
 *The userdetails class is used to get the username/ password from the repository (DB)
 *The token (customer entered password ) should be matched with what we already have in repository
 *This is done using password encoder. Also this is used to store the password in hash format and also vice versa
 *i.e  it can convert the hashed format from the table and match against the raw string entered by the user
 */

@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	private static Logger log = LoggerFactory.getLogger(AccountAuthenticationProvider.class);
	
	@Autowired
	private AccountUserDetailsService accountUserDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider#additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)
	 */
	//Password validation logic implemented below.
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken token) throws AuthenticationException {
	
		//Validating that password in DB and password entered by customer is not null
		if(token.getCredentials() ==null || userDetails.getPassword() == null )
		{
		throw new  BadCredentialsException("The Credentials are null, hence this exception is thrown");
		}

		
		if(!passwordEncoder.matches((String)token.getCredentials(), userDetails.getPassword()))
		{
			log.error("Invalid Password entered : "+(String)token.getCredentials());
			throw new  BadCredentialsException("Invalid Password entered : "+(String)token.getCredentials());
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider#retrieveUser(java.lang.String, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)
	 */
	//Retrieves the UserdETAILS OBJECT for the username supplied by the user
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		log.info("Inside retrieveUser method in AccountAuthenticationProvider class " );
	
		UserDetails userDetails=accountUserDetailsService.loadUserByUsername(username);
		return userDetails;
	}

}
