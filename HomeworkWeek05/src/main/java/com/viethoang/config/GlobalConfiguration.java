package com.viethoang.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class GlobalConfiguration {
	
	@Bean
	CommandLineRunner initData() {
		return args -> {
			
		};
	}
}
