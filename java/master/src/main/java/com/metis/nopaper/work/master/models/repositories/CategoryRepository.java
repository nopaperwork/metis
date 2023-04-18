package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metis.nopaper.work.master.models.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

	List<Category> findByStatus(String defaultStatus);
}
