package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot12ScheduledApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot12ScheduledApplication.class, args);
	}
}
