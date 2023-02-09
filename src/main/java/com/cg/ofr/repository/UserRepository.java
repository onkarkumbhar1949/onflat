package com.cg.ofr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.User;

/*
 * It is a user repository interface that extends jpa repository that contains
 * inbuilt methods for various operations
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * It is used to search the User based on its username.
	 */
	
	public Optional<User> findByuserName(String userName);
}