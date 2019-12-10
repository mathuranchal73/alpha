/**
 * 
 */
package com.alpha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.model.Stop;

/**
 * @author Anchal.Mathur
 *
 */

public interface StopRepository extends MongoRepository<Stop, String> {
    Stop findByCode(String code);
}
