package com.lobin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}