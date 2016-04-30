package com.tradeengineproject.profilereader.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
//@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingEvent
{
    private Long ShoppingEvent;
    private LocalDateTime timeOfSale;
    private List<Long> productIdList;
    private LocalDateTime dateOfPurchase;
    private BigDecimal amount;
    private BigDecimal totalTax;
    private BigDecimal price;
    private BigDecimal awardedPoints;
}
