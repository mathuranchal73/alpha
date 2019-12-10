/**
 * 
 */
package com.alpha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.model.Trip;
import com.alpha.model.TripSchedule;

/**
 * @author Anchal.Mathur
 *
 */

public interface TripScheduleRepository extends MongoRepository<TripSchedule, String> {
    TripSchedule findByTripDetailAndTripDate(Trip tripDetail, String tripDate);
}
