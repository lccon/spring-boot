package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CostumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostumerUserApplication.class, args);
	}

	@LoadBalanced //使用负载均衡机制
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
