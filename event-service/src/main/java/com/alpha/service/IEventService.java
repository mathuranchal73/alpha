package com.alpha.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.payload.UserRequest;

@Service
public interface IEventService {

	ResponseEntity<?> addStudentProfile(HttpServletRequest request, UserRequest user);

}
