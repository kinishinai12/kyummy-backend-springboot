package com.kinishinai.kyummybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KyummybackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyummybackendApplication.class, args);
	}

}
