/**
 * 
 */
package com.alpha.mapper;

import com.alpha.dto.TripScheduleDto;
import com.alpha.model.Trip;
import com.alpha.model.TripSchedule;

/**
 * @author Anchal.Mathur
 *
 */
public class TripScheduleMapper {
	
	public static TripScheduleDto toTripScheduleDto(TripSchedule tripSchedule) {
        Trip tripDetails = tripSchedule.getTripDetail();
        return new TripScheduleDto(tripSchedule.getId(),tripDetails.getId(),tripSchedule.getAvailableSeats(),tripDetails.getFare(),tripDetails.getJourneyTime(),tripDetails.getBus().getCode(),tripDetails.getSourceStop().getName(),tripDetails.getDestStop().getName());
               
    }

}
