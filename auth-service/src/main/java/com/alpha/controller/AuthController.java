package com.alpha.controller;

import org.springframework.web.bind.annotation.RestController;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alpha.model.User;
import com.alpha.service.UserService;


@RestController
public class AuthController {
	
	private static Logger logger = Logger.getLogger(AuthController.class);

	@Autowired
	RestTemplate restTemplete;
	
	@Autowired
	private UserService userService;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user) {
		userService.create(user);
	}
	
	
	@RequestMapping(value = "/elk")
	public String helloWorld() {
		String response = "Welcome to JavaInUse" + new Date();
		logger.info(response); 

		return response;
	}

	@RequestMapping(value = "/exception")
	public String exception() {
		String response = "";
		try {
			throw new Exception("Exception has occured....");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			logger.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
	}

}
