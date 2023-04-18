package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
	Optional<Department> findByName(UUID id);

	List<Department> findByStatus(String defaultStatus);
}
