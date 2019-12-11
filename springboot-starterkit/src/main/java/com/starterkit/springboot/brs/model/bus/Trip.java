package com.starterkit.springboot.brs.model.bus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Arpit Khandelwal.
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(int journeyTime) {
		this.journeyTime = journeyTime;
	}

	public Stop getSourceStop() {
		return sourceStop;
	}

	public void setSourceStop(Stop sourceStop) {
		this.sourceStop = sourceStop;
	}

	public Stop getDestStop() {
		return destStop;
	}

	public void setDestStop(Stop destStop) {
		this.destStop = destStop;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
    
    

}
