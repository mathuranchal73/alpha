package com.alpha.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.payload.SignUpRequest;

@Service
public interface IUserService {

	ResponseEntity<?> addUser(String header, @Valid SignUpRequest signUpRequest);

}
