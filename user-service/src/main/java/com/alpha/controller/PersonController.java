package com.alpha.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.payload.SignUpRequest;
import com.alpha.service.IPersonService;
import com.alpha.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/user")
@Api(value="User Service", description = "Data service operations on Users", tags=("User"))
public class PersonController {
	
private static Logger logger = Logger.getLogger(PersonController.class);
	

	
	
	@ApiOperation(value="Add", notes="Add the User Profile", nickname="addProfile")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully Added Profile"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.POST, produces = "application/json")
    public void addProfile() throws Exception 
    {
    	
    }


}
