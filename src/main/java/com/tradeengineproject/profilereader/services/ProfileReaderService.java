package com.tradeengineproject.profilereader.services;

import com.tradeengineproject.profilereader.ws_bindings.operations.CreateLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.CreateLoyalityAccountResponse;
import com.tradeengineproject.profilereader.ws_bindings.operations.DeleteLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.DeleteLoyalityAccountResponse;
import com.tradeengineproject.profilereader.ws_bindings.operations.GetLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.GetLoyalityAccountResponse;

public interface ProfileReaderService
{
    CreateLoyalityAccountResponse createLoyalityAccount(CreateLoyalityAccountRequest request);
    GetLoyalityAccountResponse getLoyalityAccount(GetLoyalityAccountRequest request);
    DeleteLoyalityAccountResponse deleteLoyalityAccount(DeleteLoyalityAccountRequest request);
//    void updateLoyalityAccount();
}
