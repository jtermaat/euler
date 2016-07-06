package com.euler.controller;

import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.euler.EulerSpringApplication;
import com.euler.entities.Mission;
import com.euler.entities.MissionSolution;

@Component
public class MissionSender {
	
	@Scheduled(fixedRate = 3000)
		public void sendPost() {
			
			try {
				String url = EulerSpringApplication.URL;
				Mission mission = getNewMission();
				ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
				RestTemplate restTemplate = new RestTemplate(requestFactory);		 
				HttpEntity<Mission> request = new HttpEntity<>(mission);
				MissionSolution response = restTemplate.postForObject(url, request, MissionSolution.class);
				
				// Print results of response
				System.out.println(response);
			}
			
	        catch (HttpClientErrorException e)
	        {
	        	// In error, print status code.
	        	HttpStatus status = e.getStatusCode();
	        	System.out.println("response status: " + status);
	           
	        }
		}
			
		private Mission getNewMission() {
			Random rand = new Random();
			Integer nextInteger = rand.nextInt(19000);
			Integer seed = nextInteger + 1000;
			Mission mission = new Mission();
			mission.setMissionId(1); // TODO: Handle persistence
			mission.setSeed(seed);
			return mission;
		}
}
