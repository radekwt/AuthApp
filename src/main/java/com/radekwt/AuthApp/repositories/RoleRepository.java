package com.radekwt.AuthApp.repositories;

import com.radekwt.AuthApp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
