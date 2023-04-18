package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.TimeZone;

public interface TimeZoneRepository extends JpaRepository<TimeZone, UUID> {
	Optional<TimeZone> findByName(UUID id);

	List<TimeZone> findByStatus(String defaultStatus);
}
