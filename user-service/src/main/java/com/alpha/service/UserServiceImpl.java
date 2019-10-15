package com.alpha.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.alpha.payload.SignUpRequest;

public class UserServiceImpl implements IUserService {

	@Override
	public ResponseEntity<?> addUser(String header, @Valid SignUpRequest signUpRequest) {
		
		return null;
	}

}
