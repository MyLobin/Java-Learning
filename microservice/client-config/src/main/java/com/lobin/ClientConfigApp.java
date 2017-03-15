package com.lobin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClientConfigApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientConfigApp.class).web(true).run(args);
	}
}
