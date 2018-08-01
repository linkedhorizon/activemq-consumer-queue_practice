package org.lyg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqApp {
	public static void main(String[] args){

		ApplicationContext context = SpringApplication.run(ActivemqApp.class,args);
	}
}
