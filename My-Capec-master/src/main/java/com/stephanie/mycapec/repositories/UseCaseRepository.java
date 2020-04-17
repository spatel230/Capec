package com.stephanie.mycapec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephanie.mycapec.models.UseCase;

public interface UseCaseRepository extends JpaRepository<UseCase, Long> {
	
	UseCase findByTitle(final String title);
}
