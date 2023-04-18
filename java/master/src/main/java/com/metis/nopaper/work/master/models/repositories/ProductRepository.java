package com.metis.nopaper.work.master.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metis.nopaper.work.master.models.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

	@Query("SELECT p FROM Product p WHERE p.subCategoryId = :subCategoryId and p.status = :status")
	List<Product> getProductBySubCategoryId(@Param("subCategoryId") UUID id, @Param("status") String status);

	List<Product> findByStatus(String defaultStatus);
}
