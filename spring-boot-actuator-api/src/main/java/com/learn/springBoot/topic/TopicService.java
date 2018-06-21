package com.learn.springBoot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired //( when spring creates the topic service instance, it is going to inject the topicrepository here)
	private TopicRepository topicRepository;
	
List<Topic> staticTopics=	new ArrayList<>(Arrays.asList(
			   new Topic("java", "Java8", "A course about java"),
			   new Topic("javaScript", "JavaScript8.0", "A course about javascript")));

public List<Topic> getAllStaticTopics() {
	return staticTopics;
	}


public List<Topic> getAllTopics() {
	
	System.out.println("Getting All topics from the database");
	List<Topic> Alltopics = new ArrayList<>();
	//topicRepository.findAll().forEach(Alltopics::add );//method reference (add method)in java 8 using lamda 
	Iterable<Topic> iterable = topicRepository.findAll();
	for(Topic t : iterable) 
	{
		Alltopics.add(t); //http://stackoverflow.com/questions/6416706/easy-way-to-change-iterable-into-collection
	}
	return Alltopics;
	 //create a new list
	 //findall returns a iterable, we are iterating over the results of iterable and putting each of the entry into a list here.
	}

public Topic getTopic(String id) {
	System.out.println("Getting the results for topicId :" + id );
	return topicRepository.findOne(id);
	}


public void addTopic(Topic topic) {
	// TODO Auto-generated method stub
	System.out.println("Adding a new topic to the database : " + topic.getId());
   topicRepository.save(topic);

}


public void updateTopic(String id, Topic topic) {
	System.out.println("Updating for topic Id : " + id);
	topicRepository.save(topic);
	
}
// Save method is used for both insert(add) and update. If the row doesnot exist, it will insert, if already exists , it will update.

public void deleteTopic(String id) {
	System.out.println(" Deleting the topic Id : " + id );
topicRepository.delete(id);
	
}


public List<Topic> getTopicByName(String nameParam) {
	// TODO Auto-generated method stub
	System.out.println("Getting topics for name : " + nameParam);
	return  topicRepository.findByName(nameParam);
}


}
