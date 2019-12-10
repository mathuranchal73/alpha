/**
 * 
 */
package com.alpha.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.model.Agency;
import com.alpha.model.Bus;
import com.alpha.model.Stop;
import com.alpha.model.Trip;

/**
 * @author Anchal.Mathur
 *
 */

public interface TripRepository extends MongoRepository<Trip, String> {
    Trip findBySourceStopAndDestStopAndBus(Stop source, Stop destination, Bus bus);

    List<Trip> findAllBySourceStopAndDestStop(Stop source, Stop destination);

    List<Trip> findByAgency(Agency agency);
}
