package com.learn.springBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.springBoot.model.Account;

/**
 * @author rajes
 * date    Jan 18, 201711:35:12 PM
 *
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	 Account findByUsername(String username);

}
