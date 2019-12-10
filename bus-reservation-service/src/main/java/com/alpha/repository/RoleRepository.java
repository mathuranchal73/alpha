package com.alpha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.RoleName;
import com.alpha.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	 Optional<Role> findByName(RoleName roleName);

}
