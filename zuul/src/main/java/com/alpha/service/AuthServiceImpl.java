package com.alpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.alpha.payload.JwtAuthenticationResponse;
import com.alpha.payload.LoginRequest;
import com.alpha.service.IAuthService;
import com.alpha.exception.CustomZuulException;
import com.alpha.security.JwtTokenProvider;

@Service
public class AuthServiceImpl implements IAuthService {
	
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    

	
	@Override
	public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
		
		        
		try {
			Authentication authentication = authenticationManager.authenticate(
	                 new UsernamePasswordAuthenticationToken(
	                         loginRequest.getUsername(),
	                         loginRequest.getPassword()
	                 )
	         );
        	 SecurityContextHolder.getContext().setAuthentication(authentication);
        	 String jwt = jwtTokenProvider.generateToken(authentication);
        	
        		 return(new JwtAuthenticationResponse(jwt));
        	 
             
		} catch (DisabledException d) {
            throw new CustomZuulException("Account Disabled", HttpStatus.UNAUTHORIZED);
		}
		catch ( LockedException l) {
            throw new CustomZuulException("Account Locked", HttpStatus.UNAUTHORIZED);
		}
		catch ( BadCredentialsException e) {
            throw new CustomZuulException("Invalid Username or Password", HttpStatus.UNAUTHORIZED);
		}
        }


	@Override
	public Boolean logoutUser(String token) {
		// TODO Auto-generated method stub
		if(isValidToken(token))
		{
			return jwtTokenProvider.logoutToken(token);
		}
		
		return false;
	}

	@Override
	public Boolean isValidToken(String token) {
		 
		return jwtTokenProvider.validateToken(token);
    	
	}

	@Override
	public String createNewToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}


}
