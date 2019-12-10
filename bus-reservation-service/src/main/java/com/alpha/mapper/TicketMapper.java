
package com.alpha.mapper;

import com.alpha.dto.TicketDto;
import com.alpha.model.Ticket;

/**
 * @author Anchal.Mathur
 *
 */
public class TicketMapper {
	
	 public static TicketDto toTicketDto(Ticket ticket) {
	        return new TicketDto(ticket.getId(),ticket.getTripSchedule().getTripDetail().getBus().getCode(),ticket.getSeatNumber(),false,ticket.getJourneyDate(),ticket.getTripSchedule().getTripDetail().getSourceStop().getName(),ticket.getTripSchedule().getTripDetail().getDestStop().getName(),ticket.getPassenger().getFullName(),ticket.getPassenger().getMobileNumber());
	                
	    }

}
