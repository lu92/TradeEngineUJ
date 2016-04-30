package com.tradeengineproject.profilereader.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardId;

    @Pattern(regexp = "[09]{26}")
    private String number;

    private BigDecimal balance;

    @Pattern(regexp = "[AZ]{3}")
    private String currency;
}
