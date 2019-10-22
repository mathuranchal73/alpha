package com.alpha.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.alpha.event.StudentEvent;

import com.alpha.model.User;
import com.alpha.util.ModelMapper;
import com.alpha.web.ApiResponse;
import com.alpha.web.RequestCorrelation;





@Service
public class EventServiceImpl implements IEventService {
	
	
	private static Logger logger = Logger.getLogger(EventServiceImpl.class);
	
	@Value("${kafka.topic-name}")
	private static String TOPIC="amazingTopic";
		
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	KafkaTemplate kafkaTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<?> addStudentProfile(HttpServletRequest request,User user) {
		
		try {
			ProducerRecord<String, StudentEvent> rec = new ProducerRecord<String, StudentEvent>(TOPIC,new StudentEvent(request.getHeader(RequestCorrelation.CORRELATION_ID_HEADER),"ADD",modelMapper.mapUserObjecttoStudent(request, user)));
			this.kafkaTemplate.send(rec);
			eventPublisher.publishEvent(new StudentEvent(request.getHeader(RequestCorrelation.CORRELATION_ID_HEADER),"ADD",modelMapper.mapUserObjecttoStudent(request, user)));
			logger.info(RequestCorrelation.CORRELATION_ID_HEADER+": Event Published");
			return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Event Published"),HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(RequestCorrelation.CORRELATION_ID_HEADER+": Error Encountered in publishing Event:"+e.getStackTrace());
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Error Encountered in Publishing Event in AddStudentProfile"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}}
