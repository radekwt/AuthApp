package com.radekwt.AuthApp.repositories;

import com.radekwt.AuthApp.entities.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken,Long> {
}
