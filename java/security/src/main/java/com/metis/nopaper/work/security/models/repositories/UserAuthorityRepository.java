package com.metis.nopaper.work.security.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metis.nopaper.work.security.models.UserAuthorities;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthorities, UUID> {

}
