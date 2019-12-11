package com.starterkit.springboot.brs.controller.v1.command;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
public class AgencyFormCommand {
    @NotBlank
    @Size(min = 5, max = 100)
    private String agencyName;

    @NotBlank
    @Size(max = 100)
    private String agencyDetails;

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyDetails() {
		return agencyDetails;
	}

	public void setAgencyDetails(String agencyDetails) {
		this.agencyDetails = agencyDetails;
	}
    
    
}