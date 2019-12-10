package com.alpha;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class UserServiceApplication {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);
	
	public static void main(String[] args) {
		logger.debug("### USERSERVICE STARTED ###");
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
