/**
 * 
 */
package com.alpha.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Anchal.Mathur
 *
 */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TripDto {
	
	private String id;

    private int fare;

    private int journeyTime;

    private String sourceStopCode;

    private String sourceStopName;

    private String destinationStopCode;

    private String destinationStopName;

    private String busCode;

    private String agencyCode;
    
    

	public TripDto(String id, int fare, int journeyTime, String sourceStopCode, String sourceStopName,
			String destinationStopCode, String destinationStopName, String busCode, String agencyCode) {
		super();
		this.id = id;
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.sourceStopCode = sourceStopCode;
		this.sourceStopName = sourceStopName;
		this.destinationStopCode = destinationStopCode;
		this.destinationStopName = destinationStopName;
		this.busCode = busCode;
		this.agencyCode = agencyCode;
	}

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

	public String getSourceStopCode() {
		return sourceStopCode;
	}

	public void setSourceStopCode(String sourceStopCode) {
		this.sourceStopCode = sourceStopCode;
	}

	public String getSourceStopName() {
		return sourceStopName;
	}

	public void setSourceStopName(String sourceStopName) {
		this.sourceStopName = sourceStopName;
	}

	public String getDestinationStopCode() {
		return destinationStopCode;
	}

	public void setDestinationStopCode(String destinationStopCode) {
		this.destinationStopCode = destinationStopCode;
	}

	public String getDestinationStopName() {
		return destinationStopName;
	}

	public void setDestinationStopName(String destinationStopName) {
		this.destinationStopName = destinationStopName;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
    
    

}