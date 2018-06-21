package com.learn.springBoot.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springBoot.topic.Topic;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void addUser(MyUser user) {
		userRepository.save(user);
	}

	public MyUser getUser(Long id) {

		return userRepository.findOne(id);

	}
	
	public List<MyUser> getAllUsers() {
		
		System.out.println("Getting All Users from the database");
		List<MyUser> allUsers = new ArrayList<>();
		//topicRepository.findAll().forEach(Alltopics::add );//method reference (add method)in java 8 using lamda 
		Iterable<MyUser> iterable = userRepository.findAll();
		for(MyUser t : iterable) 
		{
			allUsers.add(t); //http://stackoverflow.com/questions/6416706/easy-way-to-change-iterable-into-collection
		}
		return allUsers;
		 //create a new list
		 //findall returns a iterable, we are iterating over the results of iterable and putting each of the entry into a list here.
		}
}