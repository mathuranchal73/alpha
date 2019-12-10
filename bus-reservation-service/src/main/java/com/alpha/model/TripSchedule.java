/**
 * 
 */
package com.alpha.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Anchal.Mathur
 *
 */

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "tripschedule")
public class TripSchedule {

	@Id
    private String id;

    @DBRef
    private Trip tripDetail;

    @DBRef(lazy = true)
    private List<Ticket> ticketsSold;

    private String tripDate;

    private int availableSeats;
    
    

	public TripSchedule(Trip tripDetail,String tripDate,int availableSeats) {
		super();
		this.tripDetail = tripDetail;
		this.tripDate = tripDate;
		this.availableSeats = availableSeats;
	}

	public String getId() {
		return id;
	}

	public Trip getTripDetail() {
		return tripDetail;
	}

	public List<Ticket> getTicketsSold() {
		return ticketsSold;
	}

	public String getTripDate() {
		return tripDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTripDetail(Trip tripDetail) {
		this.tripDetail = tripDetail;
	}

	public void setTicketsSold(List<Ticket> ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
    
    
}
