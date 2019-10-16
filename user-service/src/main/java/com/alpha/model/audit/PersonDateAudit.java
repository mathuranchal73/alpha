package com.alpha.model.audit;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"registeredAt", "lastModifiedAt"},
        allowGetters = true
)
public abstract class PersonDateAudit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@CreatedDate
    @Column(nullable = true, updatable = false)
    private Instant registeredAt;
	
	@LastModifiedDate
    @Column(nullable = true)
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
