package com.radekwt.AuthApp.repositories;

import com.radekwt.AuthApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
