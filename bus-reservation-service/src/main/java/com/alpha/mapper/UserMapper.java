/**
 * 
 */
package com.alpha.mapper;

import java.util.HashSet;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.alpha.dto.RoleDto;
import com.alpha.dto.UserDto;
import com.alpha.model.User;

/**
 * @author Anchal.Mathur
 *
 */
public class UserMapper {

	 public static UserDto toUserDto(User user) {
	        return new UserDto(user.getEmail(),user.getFirstName(),user.getLastName(),
	        		user.getMobileNumber(),
	        		new HashSet<RoleDto>(user.getRoles().stream().map(role-> new ModelMapper().map(role,RoleDto.class)).collect(Collectors.toSet())));
	               
	    }
}
