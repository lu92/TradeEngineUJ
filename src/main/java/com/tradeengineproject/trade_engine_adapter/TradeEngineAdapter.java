package com.tradeengineproject.trade_engine_adapter;

import com.tradeengineproject.profilereader.domain.entities.LoyalityAccount;

public interface TradeEngineAdapter
{
    LoyalityAccount loginCustomer(String username, String password);
    void getShoppingHistory(long customerId);
    void getAllProducts();
    void getProductsByCategory(long categoryId);
    void getCategories();

}
