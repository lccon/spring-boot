package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBoot10CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot10CacheApplication.class, args);
	}

}
