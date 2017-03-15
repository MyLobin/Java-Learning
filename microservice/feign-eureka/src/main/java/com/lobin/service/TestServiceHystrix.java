package com.lobin.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceHystrix implements TestService{

	public String list() {
		return "error:feign hystrix excute";
	}

}
