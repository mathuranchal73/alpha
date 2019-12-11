package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.bus.TicketDto;
import com.starterkit.springboot.brs.model.bus.Ticket;

/**
 * Created by Arpit Khandelwal.
 */
public class TicketMapper {
	 public static TicketDto toTicketDto(Ticket ticket) {
	        return new TicketDto(ticket.getId(),ticket.getTripSchedule().getTripDetail().getBus().getCode(),ticket.getSeatNumber(),false,ticket.getJourneyDate(),ticket.getTripSchedule().getTripDetail().getSourceStop().getName(),ticket.getTripSchedule().getTripDetail().getDestStop().getName(),ticket.getPassenger().getFullName(),ticket.getPassenger().getMobileNumber());
	                
	    }
}
