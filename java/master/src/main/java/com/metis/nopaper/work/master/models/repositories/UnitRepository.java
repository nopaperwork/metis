package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, UUID> {

	List<Unit> findByStatus(String defaultStatus);
}
