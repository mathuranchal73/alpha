package com.alpha.payload;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alpha.model.Role;

public class UserRequest {
	
	 private Long id;
	
	 private String username;
	 
	 private String password;
	 
	 private Set<Role> roles= new HashSet<>();
	 
	 private String resetPassword;
	 
	 private Instant passwordResetAt;
	 
	 private String uuid;
	 
	 private int loginRetryCount;
	 
	 private boolean isActive;
	 
	 public UserRequest(Long id, String username, String password,
				String resetPassword, Instant passwordResetAt,  boolean isActive, Set<Role> roles,
				String uuid, int loginRetryCount) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.resetPassword = resetPassword;
			this.passwordResetAt = passwordResetAt;
			this.isActive = isActive;
			this.roles = roles;
			this.uuid = uuid;
			this.loginRetryCount = loginRetryCount;
		}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	 
	 
}
