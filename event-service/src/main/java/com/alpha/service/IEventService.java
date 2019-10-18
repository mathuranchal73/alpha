package com.alpha.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IEventService {

	ResponseEntity<?> addStudentProfile();

}
