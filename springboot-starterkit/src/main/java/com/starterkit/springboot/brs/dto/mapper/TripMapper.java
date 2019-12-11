package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.bus.TripDto;
import com.starterkit.springboot.brs.model.bus.Trip;

/**
 * Created by Arpit Khandelwal.
 */
public class TripMapper {
	public static TripDto toTripDto(Trip trip) {
        return new TripDto(trip.getId(),trip.getFare(),trip.getJourneyTime(),trip.getSourceStop().getCode(),trip.getSourceStop().getName(),trip.getDestStop().getCode(),trip.getDestStop().getName(),trip.getBus().getCode(),trip.getAgency().getCode());
                
    }
}
