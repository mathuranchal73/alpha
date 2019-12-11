package com.starterkit.springboot.brs.controller.v1.command;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
public class TripFormCommand {
    @NotBlank
    private String sourceStop;

    @NotBlank
    private String destinationStop;

    @NotBlank
    private String busCode;

    @Positive
    private int tripDuration;

    @Positive
    private int tripFare;

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

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}

	public int getTripFare() {
		return tripFare;
	}

	public void setTripFare(int tripFare) {
		this.tripFare = tripFare;
	}
    
    
}
