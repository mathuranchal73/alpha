/**
 * 
 */
package com.alpha.mapper;

import com.alpha.dto.TripDto;
import com.alpha.model.Trip;

/**
 * @author Anchal.Mathur
 *
 */
public class TripMapper {
	
	 public static TripDto toTripDto(Trip trip) {
	        return new TripDto(trip.getId(),trip.getFare(),trip.getJourneyTime(),trip.getSourceStop().getCode(),trip.getSourceStop().getName(),trip.getDestStop().getCode(),trip.getDestStop().getName(),trip.getBus().getCode(),trip.getAgency().getCode());
	                
	    }

}
