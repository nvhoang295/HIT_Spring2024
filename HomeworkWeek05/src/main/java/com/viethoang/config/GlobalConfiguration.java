package com.viethoang.config;

import com.viethoang.entity.Account;
import com.viethoang.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GlobalConfiguration {
	private final AccountRepository repository;
	
	@Bean
	CommandLineRunner initData() {
		return args -> {
			for (int i = 1; i < 10; i++) {
				repository.save(Account.builder().username("account" + i).password("123").build());
			}
		};
	}
}
