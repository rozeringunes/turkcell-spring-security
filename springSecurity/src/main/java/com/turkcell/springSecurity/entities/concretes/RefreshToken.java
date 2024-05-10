package com.turkcell.springSecurity.entities.concretes;

import com.turkcell.springSecurity.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="refresh_tokens")
public class RefreshToken extends BaseEntity <Integer> {
    private String revokedByIp;
    private LocalDateTime revokedDate;
    private String token;
    private LocalDateTime expirationDate;
    private String revokeReason;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
