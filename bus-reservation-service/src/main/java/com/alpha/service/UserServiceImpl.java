/**
 * 
 */
package com.alpha.service;



import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alpha.dto.UserDto;
import com.alpha.model.User;
import com.alpha.repository.UserRepository;
import com.alpha.exception.BRSException;
import com.alpha.exception.EntityType;
import com.alpha.exception.ExceptionType;

import static com.alpha.exception.EntityType.USER;
import static com.alpha.exception.ExceptionType.ENTITY_NOT_FOUND;


/**
 * @author Anchal.Mathur
 *
 */
@Component
public class UserServiceImpl  implements UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	 /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    public UserDto findUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw exception(USER, ENTITY_NOT_FOUND, email);
    }
    
    
    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return BRSException.throwException(entityType, exceptionType, args);
    }


}
