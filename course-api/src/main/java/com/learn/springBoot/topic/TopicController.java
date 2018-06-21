package com.learn.springBoot.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
@RequestMapping(value="/testTopics")
public String getAllTopicsTest()
{
	return "All Test topics";
}
	


@RequestMapping(value="/staticTopics")
public List<Topic> getAllStaticTopics()
{
	return topicService.getAllStaticTopics();
}

@RequestMapping(value="/staticTopicss")
public Topic getAllStaticTopicss()
{
	return topicService.getAllStaticTopicss();
}

@RequestMapping(value="/topics")
public List<Topic> getAllTopics()
{
	return topicService.getAllTopics();
}

@RequestMapping(value="/topics/{id}")
public Topic getTopic(@PathVariable("id") String id)
{
	return topicService.getTopic(id);
}

@RequestMapping(value="/topics/name/{nameParam}")
public List<Topic> getTopicByName(@PathVariable("nameParam") String nameParam)
{
	return topicService.getTopicByName(nameParam);
}

@RequestMapping(method=RequestMethod.POST,value="/topics")
public void addTopic( @RequestBody Topic topic) //Request payload will contain json representation of topic instance
{
	 topicService.addTopic(topic);
}

@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
public void addTopic( @RequestBody Topic topic,@PathVariable("id") String id) //Request payload will contain json representation of topic instance 
{
	 topicService.updateTopic(id,topic);
}

@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
public void addTopic( @PathVariable("id") String id) //Request payload will contain json representation of topic instance 
{
	 topicService.deleteTopic(id);
}




}
