/**
 * Jan 14, 2017
 * RMAHAD
 */
package com.learn.springBoot.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author RMAHAD
 *
 */
@Component
public class TopicBatch {
	
	private static final Logger log = LoggerFactory.getLogger(TopicBatch.class);
	
	
	//@Scheduled(cron="0,15 * * * * *")  // run this method with cron job at every 0 and 15th second of every minute of eevery hour,every day , every month.
	public void cronDemo()
	{
		log.info(" >> Cron Job executed at "+ System.currentTimeMillis());
	}
	

	//@Scheduled(initialDelay=3000,fixedRate=10000)  
	public void fixedRateJobWithInitialDelay() throws InterruptedException
	{
		log.info(" >> Fixed rate Job started at "+ System.currentTimeMillis());
		Thread.sleep(2000);
		log.info(" >> Fixed rate Job Ended at "+ System.currentTimeMillis());
		// The time between the execution (10secs) is measured as current job start time - previous job start time
		//The initial delay is the no. of secs after which the job will run after the server startup.
	}
	






	//@Scheduled(initialDelay=3000,fixedDelay=10000)  
	public void fixedDelayJobWithInitialDelay() throws InterruptedException
	{
		log.info(" >> Fixed delay Job started at "+ System.currentTimeMillis());
		Thread.sleep(2000);
		log.info(" >> Fixed delay Job Ended at "+ System.currentTimeMillis());
		
		// The time between the execution  (10 secs)is measured as current job end time - previous job end time
		//The job executes after 10 secs from the end time of the previous job run.
				//The initial delay is the no. of secs after which the job will run after the server startup.
	}}
