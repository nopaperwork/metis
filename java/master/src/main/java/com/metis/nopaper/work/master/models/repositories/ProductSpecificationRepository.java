package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.ProductSpecification;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, UUID> {
	Optional<ProductSpecification> findByName(UUID id);

	List<ProductSpecification> findByStatus(String defaultStatus);
}
