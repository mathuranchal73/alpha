package com.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.JwtToken;

@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken, String> {

}
