package com.status.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthStatusController {
	
	@RequestMapping("/test")
	public String testMethod() {
		
		return "Request Success";
		
	}

}
