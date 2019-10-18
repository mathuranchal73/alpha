package com.alpha.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.event.StudentProfileAddEvent;



@Service
public class EventServiceImpl implements IEventService {
	
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;



	@Override
	public ResponseEntity<?> addStudentProfile() {
		eventPublisher.publishEvent(new StudentProfileAddEvent(appUrl, request.getLocale(),result));
		return null;
	}}
