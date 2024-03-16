package com.viethoang;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeworkWeek01ApplicationTests {
	@Autowired
	@Qualifier("Naked")
	private Outfit outfit;
	
	@Test
	void contextLoads() {
		assertNotNull(outfit);
	}

}
