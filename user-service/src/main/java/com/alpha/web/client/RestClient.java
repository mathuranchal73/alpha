package com.alpha.web.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.alpha.model.User;

@Component
public interface RestClient {
	
	String postStudentService(HttpServletRequest request, User result);
	
}
