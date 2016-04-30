package com.tradeengineproject.profilereader.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoyalityAccount
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loyalityAccountId;
    private LocalDate creationDate;
    private Long points;
    private TierLevel tierLevel;

    @OneToOne @JoinColumn(name = "customerId")
    private Customer customer;

}
