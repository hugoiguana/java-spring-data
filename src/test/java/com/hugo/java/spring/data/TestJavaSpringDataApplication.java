package com.hugo.java.spring.data;

import org.springframework.boot.SpringApplication;

public class TestJavaSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.from(JavaSpringDataApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
