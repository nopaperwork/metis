package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metis.nopaper.work.master.models.State;

public interface StateRepository extends JpaRepository<State, UUID>{
	
	@Query("SELECT s FROM State s WHERE s.countryId = :countryId and s.status = :status")
	List<State> getStateListByCountryId(@Param("countryId") UUID id, @Param("status") String status);

	List<State> findByStatus(String defaultStatus);
}
