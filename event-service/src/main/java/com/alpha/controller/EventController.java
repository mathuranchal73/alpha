package com.alpha.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/event")
@Api(value="Event Service", description = "Data service operations on Users", tags=("Event"))
public class EventController {
	
	@RequestMapping(value = "/addStudentProfile", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> addStudentProfile() throws Exception 
    {
    	return eventService.addStudentProfile();
    }

}