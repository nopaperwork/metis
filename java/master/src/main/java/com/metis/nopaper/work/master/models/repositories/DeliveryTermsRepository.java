package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.DeliveryTerms;

public interface DeliveryTermsRepository extends JpaRepository<DeliveryTerms, UUID> {
	Optional<DeliveryTerms> findByName(UUID id);

	List<DeliveryTerms> findByStatus(String defaultStatus);
}
