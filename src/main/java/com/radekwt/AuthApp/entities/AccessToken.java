package com.radekwt.AuthApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="access_tokens")
public class AccessToken {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "access_token_id_seq")
    private Long id;
    private String token;
    private User user;
    private Instant expiryDate;

}
