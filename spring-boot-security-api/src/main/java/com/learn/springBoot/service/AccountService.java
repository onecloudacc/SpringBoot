package com.learn.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springBoot.model.Account;
import com.learn.springBoot.repository.AccountRepository;

/**
 * @author rajes
 * date    Jan 18, 201711:41:14 PM
 *
 */
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account findByUsername( String username)
	{
		Account account =accountRepository.findByUsername(username);
		return account;
	}
	
	
	
}
