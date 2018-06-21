/**
 * Jan 9, 2017
 * rmahad
 */
package com.learn.springBoot.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rmahad
 *
 */
@Repository
public interface UserRepository extends CrudRepository<MyUser, Long>{
	
	public MyUser findByUserName(String userName);

}