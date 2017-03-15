package com.lobin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientConfigApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientConfigApp.class).web(true).run(args);
	}
}
