package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.IndustryType;

public interface IndustryTypeRepository extends JpaRepository<IndustryType, UUID> {
	Optional<IndustryType> findByName(UUID id);

	List<IndustryType> findByStatus(String defaultStatus);
}
