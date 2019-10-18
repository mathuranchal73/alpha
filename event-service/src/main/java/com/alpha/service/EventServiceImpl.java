package com.alpha.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.event.StudentProfileAddEvent;
import com.alpha.model.User;
import com.alpha.util.ModelMapper;
import com.alpha.web.ApiResponse;
import com.alpha.web.RequestCorrelation;

import ch.qos.logback.classic.Logger;



@Service
public class EventServiceImpl implements IEventService {
	
	
	private static Logger logger = Logger.getLogger(EventServiceImpl.class);
	
	
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Override
	public ResponseEntity<?> addStudentProfile(HttpServletRequest request,User user) {
		
		try {
			eventPublisher.publishEvent(new StudentProfileAddEvent(request.getHeader(RequestCorrelation.CORRELATION_ID_HEADER),modelMapper.mapUserObjecttoStudent(request, user)));
			logger.info(RequestCorrelation.CORRELATION_ID_HEADER+": Event Published");
			return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Event Published"),HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(RequestCorrelation.CORRELATION_ID_HEADER+": Error Encountered in publishing Event:"+e.getStackTrace());
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Error Encountered in Publishing Event in AddStudentProfile"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}}
