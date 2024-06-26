package com.viethoang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HomeworkWeek01Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HomeworkWeek01Application.class, args);
		
		Person p = context.getBean(Person.class);
		p.getPersonInfor();
		
	}

}
