package com.alpha.service;


import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alpha.exception.AppException;
import com.alpha.model.Person;
import com.alpha.model.Role;
import com.alpha.model.RoleName;
import com.alpha.model.User;
import com.alpha.payload.SignUpRequest;
import com.alpha.repository.PersonRepository;
import com.alpha.repository.RoleRepository;
import com.alpha.repository.UserRepository;
import com.alpha.web.ApiResponse;
import com.alpha.web.RequestCorrelation;
import com.sms.event.OnRegistrationSuccessEvent;

@Service
public class UserServiceImpl implements IUserService {
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	@Autowired
    PasswordEncoder passwordEncoder;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ResponseEntity<?> addUser(HttpServletRequest request, @Valid SignUpRequest signUpRequest) {
		
		String correlationId = RequestCorrelation.getId();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(RequestCorrelation.CORRELATION_ID_HEADER, correlationId);
        
		if(request.getHeader("SourceAppCD")==null || request.getHeader("SourceAppCD")=="")
		{
			logger.error(correlationId+":"+ "SourceAppCD is empty in Request Header");
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "SourceAppCD is empty in Request Header"),HttpStatus.BAD_REQUEST);
		}
		
		else if(userRepository.existsByUsername(signUpRequest.getUsername())) {
			logger.debug(correlationId+":"+ "Username is already taken");
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
		
		User user = new User(signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()),UUID.randomUUID().toString()); 
		  Role userRole = roleRepository.findByName(RoleName.ROLE_SYSTEM)
	                .orElseThrow(() -> new AppException("User Role not set."));

				try {
						//Initially setting the user to InActive
						user.setActive(false);
						//Initially setting the user to InActive
				        user.setRoles(Collections.singleton(userRole));
						User result = userRepository.save(user);
						logger.info(correlationId+":"+ "User Successfully Saved");	
							if(result!=null && result.getRoles().stream().equals(RoleName.ROLE_TEACHER))
							{
								String appUrl = request.getContextPath();

								Person person= new Person("Guest", "User",request.getHeader("CountryCD"),request.getHeader("SourceAppCD"),result.getUuid());
								person.setCreatedBy(1L);
								Instant timestamp = Instant.now();
								person.setRegisteredAt(timestamp);
								person.setLastModifiedAt(timestamp);
								
									try {
											personRepository.save(person);
											logger.info(correlationId+":"+ "Default Profile Successfully Saved");	
										} 
									catch (Exception e)
										{
											logger.error(correlationId+":"+ e);
											return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Exception occured in saving default profile"),
								                    HttpStatus.INTERNAL_SERVER_ERROR);
										}
									
							}
							else if(result!=null && result.getRoles().stream().equals(RoleName.ROLE_ADMIN))
							{
								Person person= new Person("Guest", "User",request.getHeader("CountryCD"),request.getHeader("SourceAppCD"),result.getUuid());
								person.setCreatedBy(1L);
								Instant timestamp = Instant.now();
								person.setRegisteredAt(timestamp);
								person.setLastModifiedAt(timestamp);
								
									try {
											personRepository.save(person);
											logger.info(correlationId+":"+ "Default Profile Successfully Saved");	
										} 
									catch (Exception e)
										{
											logger.error(correlationId+":"+ e);
											return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Exception occured in saving default profile"),
								                    HttpStatus.INTERNAL_SERVER_ERROR);
										}
									
							}
							return new ResponseEntity<ApiResponse>(new ApiResponse(true, "User and Default Profile Successfully Saved"),
				                    HttpStatus.OK);
					} 
				catch (Exception e) 
						{
							logger.error(correlationId+":"+ e);
							return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Exception occured in saving User"),
				                    HttpStatus.INTERNAL_SERVER_ERROR);
						}
			
		
	}

}
