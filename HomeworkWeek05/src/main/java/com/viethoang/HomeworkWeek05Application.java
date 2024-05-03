package com.viethoang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomeworkWeek05Application {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkWeek05Application.class, args);
	}

}
