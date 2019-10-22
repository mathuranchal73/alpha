package com.alpha.payload;

import javax.validation.constraints.NotBlank;

public class AuthRequest {
	
	@NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
    
    

    public AuthRequest(@NotBlank String usernameOrEmail, @NotBlank String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

	public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
	

}
