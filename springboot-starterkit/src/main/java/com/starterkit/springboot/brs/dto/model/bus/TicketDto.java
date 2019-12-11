package com.starterkit.springboot.brs.dto.model.bus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDto {
    private String id;

    private String busCode;

    private int seatNumber;

    private boolean cancellable;

    private String journeyDate;

    private String sourceStop;

    private String destinationStop;

    private String passengerName;

    private String passengerMobileNumber;
    
    public TicketDto(String id, String busCode, int seatNumber, boolean cancellable, String journeyDate,
			String sourceStop, String destinationStop, String passengerName, String passengerMobileNumber) {
		super();
		this.id = id;
		this.busCode = busCode;
		this.seatNumber = seatNumber;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.sourceStop = sourceStop;
		this.destinationStop = destinationStop;
		this.passengerName = passengerName;
		this.passengerMobileNumber = passengerMobileNumber;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getSourceStop() {
		return sourceStop;
	}

	public void setSourceStop(String sourceStop) {
		this.sourceStop = sourceStop;
	}

	public String getDestinationStop() {
		return destinationStop;
	}

	public void setDestinationStop(String destinationStop) {
		this.destinationStop = destinationStop;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerMobileNumber() {
		return passengerMobileNumber;
	}

	public void setPassengerMobileNumber(String passengerMobileNumber) {
		this.passengerMobileNumber = passengerMobileNumber;
	}
    
    
}
