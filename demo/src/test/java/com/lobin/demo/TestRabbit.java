package com.lobin.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@EnableScheduling
public class TestRabbit {
	@Value("${tutorial.client.duration:0}")
	private int duration;

	@Autowired
	private ConfigurableApplicationContext ctx;
	

	@Test
	public void test1() throws Exception{
		System.out.println("Ready ... running for " + duration + "ms");
		Thread.sleep(duration);
		ctx.close();
	}
}
