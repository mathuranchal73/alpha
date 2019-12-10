/**
 * 
 */
package com.alpha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.model.Agency;
import com.alpha.model.User;

/**
 * @author Anchal.Mathur
 *
 */
public interface AgencyRepository extends MongoRepository<Agency, String> {
    Agency findByCode(String agencyCode);

    Agency findByOwner(User owner);

    Agency findByName(String name);
}
