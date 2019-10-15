package com.alpha.model.audit;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class PersonDateAudit implements Serializable {
	
	@CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant registeredAt;
	
	@LastModifiedDate
    @Column(nullable = false)
    private Instant lastModifiedAt;

	public Instant getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Instant registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Instant getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Instant lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	
	

}
