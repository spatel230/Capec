package com.stephanie.mycapec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephanie.mycapec.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(final String email);

}
