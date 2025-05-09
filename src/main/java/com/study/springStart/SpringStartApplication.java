package com.study.springStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.study")
public class SpringStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}

}
