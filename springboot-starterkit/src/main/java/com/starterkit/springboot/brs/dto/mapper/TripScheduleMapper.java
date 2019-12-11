package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.bus.TripScheduleDto;
import com.starterkit.springboot.brs.model.bus.Trip;
import com.starterkit.springboot.brs.model.bus.TripSchedule;

/**
 * Created by Arpit Khandelwal.
 */
public class TripScheduleMapper {
	public static TripScheduleDto toTripScheduleDto(TripSchedule tripSchedule) {
        Trip tripDetails = tripSchedule.getTripDetail();
        return new TripScheduleDto(tripSchedule.getId(),tripDetails.getId(),tripSchedule.getAvailableSeats(),tripDetails.getFare(),tripDetails.getJourneyTime(),tripDetails.getBus().getCode(),tripDetails.getSourceStop().getName(),tripDetails.getDestStop().getName());
               
    }
}
