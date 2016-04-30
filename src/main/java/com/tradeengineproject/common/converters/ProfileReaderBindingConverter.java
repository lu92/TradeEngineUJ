package com.tradeengineproject.common.converters;

import com.tradeengineproject.profilereader.domain.entities.Address;
import com.tradeengineproject.profilereader.domain.entities.CreditCard;
import com.tradeengineproject.profilereader.domain.entities.Customer;
import com.tradeengineproject.profilereader.domain.entities.LoyalityAccount;
import com.tradeengineproject.profilereader.domain.entities.TierLevel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProfileReaderBindingConverter
{
    public static LoyalityAccount toLoyalityAccount(com.tradeengineproject.tradeengine.ws_bindings.LoyalityAccount loyalityAccount)
    {
        return LoyalityAccount.builder()
                        .customer(toCustomer(loyalityAccount.getCustomer()))
                        .creationDate(LocalDate.now())
                        .tierLevel(TierLevel.STANDARD)
                        .points(0L).build();
    }

    public static com.tradeengineproject.tradeengine.ws_bindings.LoyalityAccount toLoyalityAccount(LoyalityAccount loyalityAccount)
    {
        com.tradeengineproject.tradeengine.ws_bindings.LoyalityAccount bindingLoyalityAccount =
                new com.tradeengineproject.tradeengine.ws_bindings.LoyalityAccount();
        bindingLoyalityAccount.setCustomer(toCustomer(loyalityAccount.getCustomer()));
        bindingLoyalityAccount.setTierLevel(loyalityAccount.getTierLevel().toString());
        bindingLoyalityAccount.setCreationDate(loyalityAccount.getCreationDate());
        bindingLoyalityAccount.setPoints(loyalityAccount.getPoints());

        return bindingLoyalityAccount;
    }

    public static Customer toCustomer(com.tradeengineproject.tradeengine.ws_bindings.Customer customer)
    {
        return  Customer.builder()
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .birthday(customer.getBirthday())
                .email(customer.getEmail())
                .address(toAddress(customer.getAddress()))
                .creditCard(toCreditCard(customer.getCreditCard())).build();
    }

    public static com.tradeengineproject.tradeengine.ws_bindings.Customer toCustomer(Customer customer)
    {
        com.tradeengineproject.tradeengine.ws_bindings.Customer bindingCustomer =
                new com.tradeengineproject.tradeengine.ws_bindings.Customer();

        bindingCustomer.setFirstname(customer.getFirstname());
        bindingCustomer.setLastname(customer.getLastname());
        bindingCustomer.setBirthday(customer.getBirthday());
        bindingCustomer.setEmail(customer.getEmail());
        bindingCustomer.setAddress(toAddress(customer.getAddress()));
        bindingCustomer.setCreditCard(toCreditCard(customer.getCreditCard()));

        return bindingCustomer;
    }

    public static CreditCard toCreditCard(com.tradeengineproject.tradeengine.ws_bindings.CreditCard creditCard)
    {
        return CreditCard.builder()
                .balance(new BigDecimal(creditCard.getBalance()))
                .currency(creditCard.getCurrency())
                .number(creditCard.getNumber()).build();
    }

    public static com.tradeengineproject.tradeengine.ws_bindings.CreditCard toCreditCard(CreditCard creditCard)
    {
        com.tradeengineproject.tradeengine.ws_bindings.CreditCard bindingCreditCard =
                new com.tradeengineproject.tradeengine.ws_bindings.CreditCard();

        bindingCreditCard.setNumber(creditCard.getNumber());
        bindingCreditCard.setBalance(creditCard.getBalance().doubleValue());
        bindingCreditCard.setCurrency(creditCard.getCurrency());

        return bindingCreditCard;
    }

    public static Address toAddress(com.tradeengineproject.tradeengine.ws_bindings.Address address)
    {
        return Address.builder()
                .city(address.getCity())
                .country(address.getCoutry())
                .zipCode(address.getZipCode())
                .street(address.getStreet()).build();
    }

    public static com.tradeengineproject.tradeengine.ws_bindings.Address toAddress(Address address)
    {
        com.tradeengineproject.tradeengine.ws_bindings.Address bindingAddress =
                new com.tradeengineproject.tradeengine.ws_bindings.Address();

        bindingAddress.setCity(address.getCity());
        bindingAddress.setCoutry(address.getCountry());
        bindingAddress.setStreet(address.getStreet());
        bindingAddress.setZipCode(address.getZipCode());

        return bindingAddress;
    }
}
