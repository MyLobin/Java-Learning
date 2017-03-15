package com.lobin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ActivitiDemoApp {
	public static void main(String[] args) {
		SpringApplication.run(ActivitiDemoApp.class, args);
	}
}
