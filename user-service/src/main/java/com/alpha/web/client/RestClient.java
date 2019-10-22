package com.alpha.web.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.alpha.model.User;
import com.alpha.web.ApiResponse;

@Component
public interface RestClient {
	
	ResponseEntity<ApiResponse> postStudentService(HttpServletRequest request, User result);
	
}
