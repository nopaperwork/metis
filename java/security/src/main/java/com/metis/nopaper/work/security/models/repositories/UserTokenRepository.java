package com.metis.nopaper.work.security.models.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metis.nopaper.work.security.models.UserToken;

public interface UserTokenRepository extends JpaRepository<UserToken, UUID> {

	@Query(value = " select ut.* from nopaperwork.user_token ut " 
			+ " inner join nopaperwork.users u on ut.user_id = u.id\n"
			+ " where u.id = UUID(?1) and (ut.expired = false or ut.revoked = false)", nativeQuery = true)
	List<UserToken> findAllValidTokenByUser(UUID id);

	Optional<UserToken> findByToken(String token);

}
