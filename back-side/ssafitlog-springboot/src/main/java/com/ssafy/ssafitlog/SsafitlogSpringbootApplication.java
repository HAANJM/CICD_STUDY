package com.ssafy.ssafitlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SsafitlogSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsafitlogSpringbootApplication.class, args);
	}

}
