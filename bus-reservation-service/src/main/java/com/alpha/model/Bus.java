/**
 * 
 */
package com.alpha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
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
@Document(collection = "bus")
public class Bus {
	
	@Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String code;

    private int capacity;

    private String make;

    @DBRef(lazy = true)
    private Agency agency;
    
    

	public Bus(String code, int capacity, String make, Agency agency) {
		super();
		this.code = code;
		this.capacity = capacity;
		this.make = make;
		this.agency = agency;
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getMake() {
		return make;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
    
    

}
