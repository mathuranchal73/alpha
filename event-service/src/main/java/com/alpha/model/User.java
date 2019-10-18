package com.alpha.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


public class User {
	

	private Long id;

    private String username;

    private String password;

    private String resetPassword;
    
    private Instant passwordResetAt;
	
	private boolean isActive;
	
	private Set<Role> roles= new HashSet<>();
	
    private String uuid;
	
	private int loginRetryCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Instant getPasswordResetAt() {
		return passwordResetAt;
	}

	public void setPasswordResetAt(Instant passwordResetAt) {
		this.passwordResetAt = passwordResetAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getLoginRetryCount() {
		return loginRetryCount;
	}

	public void setLoginRetryCount(int loginRetryCount) {
		this.loginRetryCount = loginRetryCount;
	}
	
	

}
