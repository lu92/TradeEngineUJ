package com.tradeengineproject.common.utils;

import com.tradeengineproject.profilereader.domain.entities.LoyalityAccount;
import com.tradeengineproject.tradeengine.ws_bindings.Result;

public class ResultBuilder
{
    public static Result getResultWhenSuccess(LoyalityAccount loyalityAccount)
    {
        Result result = new Result();
        result.setMessage("Loyality account for " +
                loyalityAccount.getCustomer().getFirstname() + " " +
                loyalityAccount.getCustomer().getLastname() + " created");
        return result;
    }

    public static Result getResultWhenFailure(LoyalityAccount loyalityAccount)
    {
        Result result = new Result();
        result.setMessage("Cannot create loyality account for " +
                loyalityAccount.getCustomer().getFirstname() + " " +
                loyalityAccount.getCustomer().getLastname() + " " +
                ", customer already has account");
        return result;
    }

    public static Result getResult(String message)
    {
        Result result = new Result();
        result.setMessage(message);
        return result;
    }
}
