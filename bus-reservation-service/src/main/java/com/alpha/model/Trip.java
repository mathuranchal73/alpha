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
@Document(collection = "trip")
public class Trip {
	
	@Id
    private String id;

    private int fare;

    private int journeyTime;

    @DBRef
    private Stop sourceStop;

    @DBRef
    private Stop destStop;

    @DBRef
    private Bus bus;

    @DBRef
    private Agency agency;
    
    

	public Trip(Stop sourceStop,Stop destStop,Agency agency,Bus bus,int journeyTime,int fare) {
		super();
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.sourceStop = sourceStop;
		this.destStop = destStop;
		this.bus = bus;
		this.agency = agency;
	}

	public String getId() {
		return id;
	}

	public int getFare() {
		return fare;
	}

	public int getJourneyTime() {
		return journeyTime;
	}

	public Stop getSourceStop() {
		return sourceStop;
	}

	public Stop getDestStop() {
		return destStop;
	}

	public Bus getBus() {
		return bus;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public void setJourneyTime(int journeyTime) {
		this.journeyTime = journeyTime;
	}

	public void setSourceStop(Stop sourceStop) {
		this.sourceStop = sourceStop;
	}

	public void setDestStop(Stop destStop) {
		this.destStop = destStop;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
    
    

}
