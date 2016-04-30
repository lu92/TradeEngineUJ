package com.tradeengineproject.profilereader.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
//@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingHistory
{
    private Long shoppingHistoryId;
    private List<ShoppingEvent> shoppingEventList;
    private BigDecimal totalAmount;
    private BigDecimal totalTaxes;
}
