package com.lobin.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lobin.demo.amq.MsgSender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class TestActive {
	 @Autowired
	    JmsTemplate jmsTemplate;
	 @Test
	 public void test(){
		 System.out.println("****************start********************");
		 jmsTemplate.send("my-destination", new MsgSender());
		 System.out.println("****************end********************");
	 }
}
