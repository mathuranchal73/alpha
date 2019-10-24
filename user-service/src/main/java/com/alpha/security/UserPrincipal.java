package com.alpha.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.alpha.model.User;
import com.alpha.security.UserPrincipal;

public class UserPrincipal implements UserDetails {
	
		private static final long serialVersionUID = 1L;
	
		private Long id;

	    private String username;

	    @JsonIgnore
	    private String password;

	    private Collection<? extends GrantedAuthority> authorities;

	    private String uuid;
	    
	    public UserPrincipal(Long id,String username, String password, Collection<? extends GrantedAuthority> authorities, String uuid) {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.authorities = authorities;
	        this.uuid= uuid;
	    }

	    public static UserPrincipal create(User user) {
	        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
	                new SimpleGrantedAuthority(role.getName().name())
	        ).collect(Collectors.toList());

	        return new UserPrincipal(
	                user.getId(),
	                user.getUsername(),
	                user.getPassword(),
	                authorities,
	                user.getUuid()
	        );
	    }

	    public Long getId() {
	        return id;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }
	    
	    public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		@Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        UserPrincipal that = (UserPrincipal) o;
	        return Objects.equals(id, that.id);
	    }

	    @Override
	    public int hashCode() {

	        return Objects.hash(id);
	    }

}