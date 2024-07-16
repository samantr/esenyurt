package com.esenyurt.app;

import com.esenyurt.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import  org.assertj.core.api.Assertions;


@SpringBootTest
class AppApplicationTests {

	@Autowired
	private PersonController personController;
	@Test
	void contextLoads() {
		Assertions.assertThat(personController).isNotNull();
	}

}
