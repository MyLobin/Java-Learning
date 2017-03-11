//package com.lobin.activitiDemo;
//
//import javax.sql.DataSource;
//
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//
//
//@SpringBootApplication
//public class App {
//	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
//	}
//	@Bean
//	public DataSource database() {
//	    return DataSourceBuilder.create()
//	        .url("jdbc:mysql://192.168.31.102:3306/test?characterEncoding=UTF-8")
//	        .username("admin")
//	        .password("123")
//	        .driverClassName("com.mysql.jdbc.Driver")
//	        .build();
//	}
//	@Bean
//	public CommandLineRunner init(final RepositoryService repositoryService, final RuntimeService runtimeService,
//			final TaskService taskService) {
//
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... strings) throws Exception {
//				System.out.println(
//						"Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
//				System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//				runtimeService.startProcessInstanceByKey("oneTaskProcess");
//				System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
//			}
//		};
//		
//		
//
//	}
//	
//}
