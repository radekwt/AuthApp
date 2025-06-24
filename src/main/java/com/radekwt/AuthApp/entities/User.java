package com.radekwt.AuthApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_seq")
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
}
