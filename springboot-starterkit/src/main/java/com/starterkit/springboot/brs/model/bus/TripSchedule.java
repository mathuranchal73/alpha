package com.starterkit.springboot.brs.model.bus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Arpit Khandelwal.
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Trip getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(Trip tripDetail) {
		this.tripDetail = tripDetail;
	}

	public List<Ticket> getTicketsSold() {
		return ticketsSold;
	}

	public void setTicketsSold(List<Ticket> ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
    
    
}
