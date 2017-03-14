package com.lobin.demo.amq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @author Zebe
 * @version 1.0.0
 */
@Component
public class MsgReceiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接收到消息：" + message);
		 System.out.println("****************get********************");
    }

}
