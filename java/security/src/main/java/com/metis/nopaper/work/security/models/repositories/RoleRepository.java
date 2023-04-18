package com.metis.nopaper.work.security.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metis.nopaper.work.security.enums.ERole;
import com.metis.nopaper.work.security.models.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, UUID> {
	Optional <Roles> findByName(ERole name);

}

