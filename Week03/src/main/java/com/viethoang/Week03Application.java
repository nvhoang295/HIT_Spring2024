package com.viethoang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Week03Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Week03Application.class, args);
		Phone phone = context.getBean(Phone.class);
		System.out.println(context.getStartupDate());
		System.out.println(phone.getName());
	}

}
