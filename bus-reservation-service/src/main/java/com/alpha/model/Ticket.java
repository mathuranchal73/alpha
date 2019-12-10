/**
 * 
 */
package com.alpha.model;

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
@Document(collection = "ticket")
public class Ticket {

	@Id
    private String id;

    private int seatNumber;

    private boolean cancellable;

    private String journeyDate;

    @DBRef
    private TripSchedule tripSchedule;

    @DBRef
    private User passenger;
    
    

	public Ticket(int seatNumber, boolean cancellable, String journeyDate, TripSchedule tripSchedule, User passenger) {
		super();
		this.seatNumber = seatNumber;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.tripSchedule = tripSchedule;
		this.passenger = passenger;
	}

	public String getId() {
		return id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public TripSchedule getTripSchedule() {
		return tripSchedule;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public void setTripSchedule(TripSchedule tripSchedule) {
		this.tripSchedule = tripSchedule;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}
    
    
}
