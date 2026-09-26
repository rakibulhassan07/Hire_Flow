package com.example.hireflow.repository;

import com.example.hireflow.entity.UserAuthAccount;
import com.example.hireflow.entity.type.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthAccountRepository
        extends JpaRepository<UserAuthAccount, Long> {

    Optional<UserAuthAccount> findByProviderAndProviderUserId(
            AuthProvider provider,
            String providerUserId
    );
}