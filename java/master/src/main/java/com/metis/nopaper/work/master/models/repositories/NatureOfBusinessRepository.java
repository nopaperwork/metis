package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.NatureOfBusiness;

public interface NatureOfBusinessRepository extends JpaRepository<NatureOfBusiness, UUID> {
	Optional<NatureOfBusiness> findByName(UUID id);

	List<NatureOfBusiness> findByStatus(String defaultStatus);
}
