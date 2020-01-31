package com.sw.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
