package com.radekwt.AuthApp.entities;

import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "access_token_id_seq")
    private Long id;
    private String token;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    private Instant expiryDate;

}
