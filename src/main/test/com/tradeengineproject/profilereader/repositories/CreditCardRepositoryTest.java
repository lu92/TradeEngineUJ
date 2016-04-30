package com.tradeengineproject.profilereader.repositories;

import com.tradeengineproject.profilereader.common.PersistentConfig;
import com.tradeengineproject.profilereader.common.PersistentTestSpecification;
import com.tradeengineproject.profilereader.domain.entities.CreditCard;
import com.tradeengineproject.profilereader.endpoints.ProfileReaderEndpoint;
import com.tradeengineproject.profilereader.services.ProfileReaderServiceImpl;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = PersistentConfig.class)
public class CreditCardRepositoryTest extends PersistentTestSpecification
{
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private ProfileReaderEndpoint profileReaderEndpoint;



    @Test
    public void test() {

        CreditCard creditCard = CreditCard.builder()
                .number("12332423423423423423424")
                .currency("USD")
                .balance(new BigDecimal(300))
                .build();

        CreditCard savedCreditCard = creditCardRepository.save(creditCard);
        assertThat(creditCardRepository.exists(savedCreditCard.getCreditCardId()));
    }

    @Test
    public void context()
    {
        assertThat(profileReaderEndpoint).isNotNull();
        ProfileReaderServiceImpl profileReaderService = (ProfileReaderServiceImpl) ReflectionTestUtils.getField(profileReaderEndpoint, "profileReaderService");
        assertThat(profileReaderService).isNotNull();

        LoyalityAccountRepository loyalityAccountRepository = (LoyalityAccountRepository) ReflectionTestUtils.getField(profileReaderService, "loyalityAccountRepository");

        assertThat(loyalityAccountRepository).isNotNull();
    }

//    @Test
//    public void cannotCreateAnotherCreditCardTest()
//    {
//        CreditCard creditCard = CreditCard.builder()
//                .number("12332423423423423423424")
//                .currency("USD")
//                .balance(new BigDecimal(300))
//                .build();
//        CreditCard savedCreditCard = creditCardRepository.save(creditCard);
//        assertThat(creditCardRepository.exists(savedCreditCard.getCreditCardId()));
//        assertThat(creditCardRepository.count()).isEqualTo(1L);
//    }

}


