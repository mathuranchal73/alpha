/**
 * 
 */
package com.alpha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.model.Agency;
import com.alpha.model.Bus;

/**
 * @author Anchal.Mathur
 *
 */

public interface BusRepository extends MongoRepository<Bus, String> {
    Bus findByCode(String busCode);

    Bus findByCodeAndAgency(String busCode, Agency agency);
}
