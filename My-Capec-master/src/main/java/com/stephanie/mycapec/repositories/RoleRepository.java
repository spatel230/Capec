package com.stephanie.mycapec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephanie.mycapec.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(final String role);

}
