package com.starterkit.springboot.brs.controller.v1.api;

import com.starterkit.springboot.brs.controller.v1.request.UserSignupRequest;
import com.starterkit.springboot.brs.dto.model.user.UserDto;
import com.starterkit.springboot.brs.dto.response.Response;
import com.starterkit.springboot.brs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Arpit Khandelwal.
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value="brs-application", description="Operations pertaining to user management in the BRS application")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Handles the incoming POST API "/v1/user/signup"
     *
     * @param userSignupRequest
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid UserSignupRequest userSignupRequest) {
    	
    	return new ResponseEntity(registerUser(userSignupRequest, false),HttpStatus.OK);
        //return Response.ok().setPayload(registerUser(userSignupRequest, false));
    }

    /**
     * Register a new user in the database
     *
     * @param userSignupRequest
     * @return
     */
    private UserDto registerUser(UserSignupRequest userSignupRequest, boolean isAdmin) {
        UserDto userDto = new UserDto();
        		userDto.setEmail(userSignupRequest.getEmail());
        		userDto.setPassword(userSignupRequest.getPassword());
        		userDto.setFirstName(userSignupRequest.getFirstName());
        		userDto.setLastName(userSignupRequest.getLastName());
        		userDto.setMobileNumber(userSignupRequest.getMobileNumber());
        		userDto.setAdmin(isAdmin);

        return userService.signup(userDto);
    }
}
