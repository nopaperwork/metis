package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.MarketStrategy;

public interface MarketStrategyRepository extends JpaRepository<MarketStrategy, UUID> {
	Optional<MarketStrategy> findByName(UUID id);

	List<MarketStrategy> findByStatus(String defaultStatus);
}
