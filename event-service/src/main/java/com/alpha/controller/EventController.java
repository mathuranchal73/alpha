package com.alpha.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.model.User;
import com.alpha.service.IEventService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/event")
@Api(value="Event Service", description = "Data service operations on Users", tags=("Event"))
public class EventController {
	
	@Autowired
	IEventService eventService;
	
	@PreAuthorize("hasRole('SYSTEM')")
	@RequestMapping(value = "/addStudentProfile", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> addStudentProfile(HttpServletRequest request,User user) throws Exception 
    {
    	return eventService.addStudentProfile(request,user);
    }

}
