/**
 * 
 */
package com.alpha.controller.v1.request;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTicketRequest {
	
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String tripID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "{constraints.NotEmpty.message}")
    @Temporal(TemporalType.DATE)
    private Date tripDate;
}
