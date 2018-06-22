package com.health.client2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class Client2Controller {
	   private static final Logger log = LoggerFactory.getLogger(Client2Controller.class);
	
	@RequestMapping("/client2")
	public String testMethod() {
	log.info(" Info log enabled");
	log.debug("Debug log enabled");
	log.warn("Warming log enabled");
	log.error("Error log enabled");
		return "Request Success";
	}
	
}

