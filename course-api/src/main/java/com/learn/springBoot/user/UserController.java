package com.learn.springBoot.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springBoot.topic.Topic;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	public List<MyUser> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{id}")
	public MyUser getCredentials(@PathVariable("id") Long id)
	{
		return userService.getUser(id);
	}
	

	@RequestMapping(method=RequestMethod.POST,value="/addUser")
	public void addCredentials(@RequestBody MyUser user)
	{
		userService.addUser(user);
	}
}