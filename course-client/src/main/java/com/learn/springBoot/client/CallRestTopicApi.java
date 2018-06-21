package com.learn.springBoot.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.learn.springBoot.model.Topic;

@Component
public class CallRestTopicApi implements CommandLineRunner{ // CommandLineRunner makes easy to run any code after the spring application is started with out any ignition

	private static final Logger log = LoggerFactory.getLogger(CallRestTopicApi.class);
	
	private String courseAppUrl;
	@Value("${country}")
	private String countryName;
	@Value("${stateCount}")
	private int  StatesCount;
	
   @Autowired
	public CallRestTopicApi(@Value("${courseApplication.url}")String courseAppUrl) { // from application.properties
		super();
		this.courseAppUrl = courseAppUrl;
	}
	public void callTopicApi(String topicId)
	{
		
	    RestTemplate restTemplate = new RestTemplate();
		//Topic topicConsumed=restTemplate.getForObject("http://localhost:8080/topics/springBoot1", Topic.class); // Url and return type.
	    Topic topicConsumed= restTemplate.getForObject(courseAppUrl, Topic.class, topicId);
		log.info("Consuming the topic api result");
		log.info("id= "+topicConsumed.getId()+"\n name= "+topicConsumed.getName()+ "\n description= "+topicConsumed.getDescription());
		log.info("Demo : Injecting values from the property file using @Value annotation");
		log.info("Country: {},StateCount: {}",countryName,StatesCount);
		
	}
	@Override
	public void run(String... arg0) throws Exception {
		callTopicApi("springBoot2");
		
	}
}
