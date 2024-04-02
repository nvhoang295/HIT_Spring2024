package com.viethoang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.viethoang.Phone;

@Configuration
public class PhoneConfig {
	
	@Bean
	Phone getPhoneBean() {
		return new Phone("Xiaomi");
	}
}
