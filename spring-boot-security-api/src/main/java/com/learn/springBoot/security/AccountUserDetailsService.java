package com.learn.springBoot.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.springBoot.model.Account;
import com.learn.springBoot.model.Role;
import com.learn.springBoot.service.AccountService;

/**
 * @author rajes
 * date    Jan 18, 201711:49:20 PM
 *
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountService accountService;
	private static Logger log = LoggerFactory.getLogger(AccountUserDetailsService.class);

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account=accountService.findByUsername(username);
		
		if(account == null)
		{
			log.info("Username not found in the repository");
			return null;
			
		}
		
		// Adding the role (code = admin,user etc) from the account object to "Granted authority object"
		Collection<GrantedAuthority>grantedAuthority = new ArrayList<GrantedAuthority>();
		
		for (Role r:account.getRoles())
		{
			grantedAuthority.add( new SimpleGrantedAuthority(r.getCode()));
		}
		
		// User implements the userdetails so wecan return User object
		User user= new User(account.getUsername(), account.getPassword(), account.isEnabled(), !account.isExpired(), !account.isCredentialsexpired(), !account.isLocked(), grantedAuthority);
		return user;
	}

}
