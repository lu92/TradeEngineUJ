package com.tradeengineproject.profilereader.repositories;

import com.tradeengineproject.profilereader.domain.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>
{
}
