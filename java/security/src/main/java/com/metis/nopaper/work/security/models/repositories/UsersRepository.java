package com.metis.nopaper.work.security.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metis.nopaper.work.security.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
	Optional<Users> findByUsername(String username);

	Boolean existsByUsername(String username);

	@Query(value = " SELECT * FROM nopaperwork.users u " 
			+ " WHERE (u.email= ?1 OR u.mobile= ?1 OR u.username = ?1) "
			+ " and u.status = 'ACTIVE' ", nativeQuery = true)
	Optional<Users> getUserDetails(String identity);

}
