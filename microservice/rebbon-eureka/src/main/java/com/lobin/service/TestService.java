package com.lobin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "listFallback")
	public String list() {
		System.out.println("go in list method..................");
		return restTemplate.getForEntity("http://ACTIVITIDEMO/list", String.class).getBody();
	}
	public String listFallback(){
		return "error:listFallback() excute";
	}
}
