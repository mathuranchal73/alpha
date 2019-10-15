package com.alpha;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alpha.controller.UserController;

@SpringBootApplication
public class UserServiceApplication {
	
	private static Logger logger = Logger.getLogger(UserServiceApplication.class);
	
	public static void main(String[] args) {
		logger.info("###### UserServiceApplication Started #####");
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
