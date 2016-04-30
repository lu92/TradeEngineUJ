package com.tradeengineproject.profilereader.common;

import com.tradeengineproject.profilereader.domain.entities.Address;
import com.tradeengineproject.profilereader.domain.entities.CreditCard;
import com.tradeengineproject.profilereader.domain.entities.Customer;
import com.tradeengineproject.profilereader.domain.entities.LoyalityAccount;
import com.tradeengineproject.profilereader.domain.entities.TierLevel;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = PersistentConfig.class)
@ContextConfiguration(locations = "persistance-config2.xml")
//@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
//@Transactional
@Rollback(true)
@TransactionConfiguration(defaultRollback=true)
public class PersistentTestSpecification extends AbstractJUnit4SpringContextTests
{
    public static final String CITY = "London";
    public static final String COUNTRY = "England";
    public static final String STREET = "Abbey Road 1";
    public static final String ZIP_CODE = "20-100 London";

    public static final String CUSTOMER_FIRSTNAME = "James";
    public static final String CUSTOMER_LASTNAME = "Bond";
    public static final LocalDate CUSTOMER_BIRTHDAY =LocalDate.of(1980, Month.JANUARY, 1);
    public static final String EMAIL = CUSTOMER_FIRSTNAME + "." + CUSTOMER_LASTNAME + "@gmail.com";


    public static final String CREDIT_CARD_NUMBER = "1233424534536456345345";
    public static final String CURRENCY = "USD";
    public static final BigDecimal BALANCE = new BigDecimal(100).setScale(2);




    protected static final Address ADDRESS = Address.builder()
            .city(CITY).country(COUNTRY).street(STREET).zipCode(ZIP_CODE)
            .build();

    protected static final CreditCard CREDIT_CARD = CreditCard.builder()
            .number(CREDIT_CARD_NUMBER)
            .balance(BALANCE)
            .currency(CURRENCY)
            .build();

    protected static final Customer CUSTOMER = Customer.builder()
            .firstname(CUSTOMER_FIRSTNAME)
            .lastname(CUSTOMER_LASTNAME)
            .birthday(CUSTOMER_BIRTHDAY)
            .email(EMAIL)
//            .address(ADDRESS)
//            .creditCard(CREDIT_CARD)
            .build();

    protected static final LoyalityAccount LOYALITY_ACCOUNT = LoyalityAccount.builder()
//            .customer(CUSTOMER)
            .tierLevel(TierLevel.STANDARD)
            .creationDate(LocalDate.of(2016, 4, 4))
            .points(10L)
            .build();

}
