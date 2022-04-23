package com.uuu.demo1;

import com.uuu.demo1.controllers.RootController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Demo1ApplicationTests {
	@Autowired
	private RootController rootController;
	@Test
	void contextLoads() {
		assertThat(rootController).isNotNull();
	}

}
