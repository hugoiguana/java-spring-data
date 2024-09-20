package com.hugo.java.spring.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class JavaSpringDataApplicationTests {

	@Test
	void contextLoads() {
	}

}
