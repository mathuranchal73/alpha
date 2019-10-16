package com.alpha.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
                "uuid"
            })
})
@ApiModel
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated account ID")
	private Long id;
	
	@NotBlank
    @Size(max = 25)
    private String username;
	
	@NotBlank
    @Size(max = 100)
    private String password;
	

    @Size(max = 100)
    private String resetPassword;
    
    private Instant passwordResetAt;
	
	@NotNull
	private boolean isActive;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles= new HashSet<>();
	
	@NotBlank
    @Size(max = 100)
    private String uuid;
	
	private int loginRetryCount;

	
	
	public User(@NotBlank @Size(max = 25) String username, @NotBlank @Size(max = 100) String password,
			 @NotBlank @Size(max = 100) String uuid) {
		super();
		this.username = username;
		this.password = password;
		this.uuid = uuid;
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
