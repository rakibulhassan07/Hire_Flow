package com.example.hireflow.entity;

import com.example.hireflow.entity.type.AuthProvider;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "user_auth_accounts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_provider_provider_user",
                        columnNames = {"provider", "provider_user_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuthAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AuthProvider provider;

    @Column(name = "provider_user_id", nullable = false)
    private String providerUserId;

    @Column(name = "provider_email")
    private String providerEmail;

    @CreationTimestamp
    private LocalDateTime createdAt;
}