package com.alpha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
