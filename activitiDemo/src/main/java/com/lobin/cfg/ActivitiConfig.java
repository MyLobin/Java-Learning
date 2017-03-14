package com.lobin.cfg;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ActivitiConfig {
	@Autowired
	private ProcessEngine processEngine;

//	@Bean
	public RepositoryService getRepositoryService() {
		return this.getRepositoryService();
	}
}
