package com.alpha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.AcademicSession;
import com.alpha.model.Session;

@Repository
public interface AcademicSessionRepository extends JpaRepository<AcademicSession,Long> {
	
	 Optional<AcademicSession> findBySession(Session session);

}
