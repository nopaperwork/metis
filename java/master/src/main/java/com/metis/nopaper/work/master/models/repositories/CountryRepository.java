package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.Country;

public interface CountryRepository extends JpaRepository<Country, UUID> {

	List<Country> findByStatus(String defaultStatus);
}
