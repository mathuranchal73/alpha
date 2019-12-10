/**
 * 
 */
package com.alpha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.model.Ticket;

/**
 * @author Anchal.Mathur
 *
 */
public interface TicketRepository extends MongoRepository<Ticket, Long> {
}
