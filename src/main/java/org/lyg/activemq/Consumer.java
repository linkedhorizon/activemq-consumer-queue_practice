package org.lyg.activemq;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
@Component
public class Consumer {

	//@JmsListener(destination = "sakura", containerFactory = "jmsQueueListener")
	@JmsListener(destination = "${queue}", containerFactory = "jmsQueueListener")
	public void receiveQueue(final TextMessage text, Session session)
			throws JMSException {
		try {
			System.out.println("Consumer收到的报文为:" + text.getText());
			
			//throw new NullPointerException();
			text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
			
		} catch (Exception e) {
			System.out.println("回滚");
			session.recover();// 此不可省略 重发信息使用
		}
	}


}
