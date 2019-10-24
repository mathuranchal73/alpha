package com.alpha.web.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.alpha.model.User;


@Component
public interface RestClient {
	
	ResponseEntity<?> postStudentService(HttpServletRequest request, User result);
	
}
