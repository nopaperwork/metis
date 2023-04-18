package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metis.nopaper.work.master.models.City;

public interface CityRepository extends JpaRepository<City, UUID> {

	@Query("SELECT c FROM City c WHERE c.stateId = :stateId and c.status = :status")
	List<City> getCityListByStateId(@Param("stateId") UUID id, @Param("status") String status);

	List<City> findByStatus(String defaultStatus);
}
