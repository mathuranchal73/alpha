package com.alpha.web.client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.alpha.model.User;


@Component
public interface RestClient {
	
	CompletableFuture<ResponseEntity<?>> postStudentService(HttpServletRequest request, User result) throws InterruptedException, ExecutionException, TimeoutException;
	
}
