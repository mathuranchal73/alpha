package com.alpha.service;


import com.alpha.payload.JwtAuthenticationResponse;
import com.alpha.payload.LoginRequest;

public interface IAuthService {
	
	JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest);

    Boolean isValidToken(String token);

    String createNewToken(String token);
	Boolean logoutUser(String token);

}
