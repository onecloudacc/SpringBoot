package com.learn.springBoot.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


//crudrepository has all the standard methods, get , put,delete etc, If you want to implement any special method which are not by defaultin crud repo , then we can write those methods in this class.
//creud repository needs 2 generic types. 1) what is the entity class ==> Topic 2) what is the type of the id in entity class ==> String
@RestResource(path="dataRest",rel="dataRest")
public interface TopicRepository extends CrudRepository<Topic, String> {

	public List<Topic> findByName(String name);
	
	//for any custom methods: syntax -> findBy{ClassFieldName}
} 
