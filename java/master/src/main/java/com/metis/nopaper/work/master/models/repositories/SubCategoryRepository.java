package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metis.nopaper.work.master.models.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID>{

	@Query("SELECT s FROM SubCategory s WHERE s.categoryId = :categoryId and s.status = :status")
	List<SubCategory> getSubCategoryByCategoryId(@Param("categoryId") UUID id, @Param("status") String status);

	List<SubCategory> findByStatus(String defaultStatus);
}
