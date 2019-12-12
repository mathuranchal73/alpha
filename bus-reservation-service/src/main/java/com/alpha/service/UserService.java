/**
 * 
 */
package com.alpha.service;

import org.springframework.stereotype.Service;

import com.alpha.dto.UserDto;

/**
 * @author Anchal.Mathur
 *
 */

public interface UserService {
    
    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    UserDto findUserByEmail(String email);
    
}

