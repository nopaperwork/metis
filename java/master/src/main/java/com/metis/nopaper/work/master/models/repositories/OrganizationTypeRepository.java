package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.OrganizationType;

public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, UUID> {
	Optional<OrganizationType> findByName(UUID id);

	List<OrganizationType> findByStatus(String defaultStatus);
}
