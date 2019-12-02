package com.alpha.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.model.User;
import com.alpha.payload.UserRequest;
import com.alpha.service.IEventService;
import com.alpha.security.CurrentUser;
import com.alpha.security.UserPrincipal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/event")
@Api(value="Event Service", description = "Data service operations on Users", tags=("Event"))
public class EventController {
	
	@Autowired
	IEventService eventService;
	
	
	@ApiOperation(value="Add", notes="Registers the user", nickname="saveUser")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully Registered"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@PreAuthorize("hasRole('SYSTEM')")
	@RequestMapping(value = "/addStudentProfile", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> addStudentProfile(HttpServletRequest request,@CurrentUser UserPrincipal currentUser,@Valid @RequestBody UserRequest user) throws Exception 
    {
		System.out.println("Inside event COntroller");
    	return eventService.addStudentProfile(request,user);
    }

}
