package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBoot11AsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot11AsyncApplication.class, args);
	}

}
