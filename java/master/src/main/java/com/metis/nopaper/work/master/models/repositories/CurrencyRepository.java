package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

	List<Currency> findByStatus(String defaultStatus);
}
