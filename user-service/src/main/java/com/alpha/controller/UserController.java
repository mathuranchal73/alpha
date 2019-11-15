package com.alpha.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.payload.SignUpRequest;
import com.alpha.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/v1/user")
@Api(value="User Service", description = "Data service operations on Users", tags=("User"))
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	
	@ApiOperation(value="Add", notes="Registers the user", nickname="saveUser")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully Registered"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> addUser(HttpServletRequest request, @Valid @RequestBody SignUpRequest signUpRequest) throws Exception 
    {
    	return userService.addUser(request,signUpRequest);
    }

}
