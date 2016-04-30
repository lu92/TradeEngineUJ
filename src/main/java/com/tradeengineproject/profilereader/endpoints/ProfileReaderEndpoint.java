package com.tradeengineproject.profilereader.endpoints;

import com.tradeengineproject.profilereader.services.ProfileReaderService;
import com.tradeengineproject.profilereader.ws_bindings.operations.CreateLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.CreateLoyalityAccountResponse;
import com.tradeengineproject.profilereader.ws_bindings.operations.GetLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.GetLoyalityAccountResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProfileReaderEndpoint
{
    @Autowired
    private ProfileReaderService profileReaderService;

    private final Logger logger = Logger.getLogger("ProfileReaderEndpoint");

    private static final String TARGET_NAMESPACE = "http://operations.ws_bindings.profilereader.tradeengineproject.com";

    public ProfileReaderEndpoint() throws ClassNotFoundException
    {
        Class.forName("org.hibernate.dialect.PostgreSQL9Dialect");
    }

    @PayloadRoot(localPart = "CreateLoyalityAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload CreateLoyalityAccountResponse createLoyalityAccount(@RequestPayload CreateLoyalityAccountRequest request)
    {
        logger.debug("CreateLoyalityAccountRequest called");
        return profileReaderService.createLoyalityAccount(request);
    }

    @PayloadRoot(localPart = "GetLoyalityAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload GetLoyalityAccountResponse getLoyalityAccount(@RequestPayload GetLoyalityAccountRequest request)
    {
        System.out.println("GetLoyalityAccountRequest called");
        return profileReaderService.getLoyalityAccount(request);
    }


    public void setProfileReaderService(ProfileReaderService profileReaderService)
    {
        this.profileReaderService = profileReaderService;
    }
}
