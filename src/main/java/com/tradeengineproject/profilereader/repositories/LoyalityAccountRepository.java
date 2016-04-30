package com.tradeengineproject.profilereader.repositories;

import com.tradeengineproject.profilereader.domain.entities.LoyalityAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyalityAccountRepository extends JpaRepository<LoyalityAccount, Long>
{
}
