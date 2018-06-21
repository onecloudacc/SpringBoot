package com.learn.springBoot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springBoot.model.Greeting;




@RestController
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	


@RequestMapping(value="/api/greetings")
public List<Greeting> getAllStaticGreetings()
{
	log.info("printing all the greetings");
	
	List<Greeting> greetings=	new ArrayList<>(Arrays.asList(
			   new Greeting(01, "welcome"),
			   new Greeting(02, "hello")));
	return greetings;
}

}