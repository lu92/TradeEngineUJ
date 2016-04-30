package com.tradeengineproject.profilereader.services;

import com.tradeengineproject.common.converters.ProfileReaderBindingConverter;
import com.tradeengineproject.common.utils.ResultBuilder;
import com.tradeengineproject.profilereader.domain.entities.Customer;
import com.tradeengineproject.profilereader.domain.entities.LoyalityAccount;
import com.tradeengineproject.profilereader.repositories.CreditCardRepository;
import com.tradeengineproject.profilereader.repositories.CustomerRepository;
import com.tradeengineproject.profilereader.repositories.LoyalityAccountRepository;
import com.tradeengineproject.profilereader.ws_bindings.operations.CreateLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.CreateLoyalityAccountResponse;
import com.tradeengineproject.profilereader.ws_bindings.operations.DeleteLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.DeleteLoyalityAccountResponse;
import com.tradeengineproject.profilereader.ws_bindings.operations.GetLoyalityAccountRequest;
import com.tradeengineproject.profilereader.ws_bindings.operations.GetLoyalityAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileReaderServiceImpl implements ProfileReaderService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoyalityAccountRepository loyalityAccountRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreateLoyalityAccountResponse createLoyalityAccount(CreateLoyalityAccountRequest request)
    {
        CreateLoyalityAccountResponse createLoyalityAccountResponse = new CreateLoyalityAccountResponse();
        LoyalityAccount loyalityAccount = ProfileReaderBindingConverter.toLoyalityAccount(request.getLoyalityAccount());

        if (!customerExists(loyalityAccount))
        {
            creditCardRepository.save(loyalityAccount.getCustomer().getCreditCard());
            customerRepository.save(loyalityAccount.getCustomer());
            loyalityAccountRepository.save(loyalityAccount);
            createLoyalityAccountResponse.setResult(ResultBuilder.getResultWhenSuccess(loyalityAccount));
        }
        else
        {
            createLoyalityAccountResponse.setResult(ResultBuilder.getResultWhenFailure(loyalityAccount));
        }
        return createLoyalityAccountResponse;
    }

    @Override
    public GetLoyalityAccountResponse getLoyalityAccount(GetLoyalityAccountRequest request)
    {
        GetLoyalityAccountResponse response = new GetLoyalityAccountResponse();
        if (loyalityAccountRepository.exists(request.getLoyalityAccountId()))
        {
            long loyalityAccountId = request.getLoyalityAccountId();
            LoyalityAccount loyalityAccount = loyalityAccountRepository.getOne(loyalityAccountId);
            response.setResult(ResultBuilder.getResult("response contains requested loyality account"));
            response.setLoyalityAccount(ProfileReaderBindingConverter.toLoyalityAccount(loyalityAccount));
        }
        else
        {
            response.setResult(ResultBuilder.getResult("loyality account with requested id doesn't exists"));
        }
        return response;
    }

    @Override
    public DeleteLoyalityAccountResponse deleteLoyalityAccount(DeleteLoyalityAccountRequest request)
    {
        DeleteLoyalityAccountResponse response = new DeleteLoyalityAccountResponse();
        if (loyalityAccountRepository.exists(request.getLoyalityAccountId()))
        {
            loyalityAccountRepository.delete(request.getLoyalityAccountId());
            response.setResult(ResultBuilder.getResult("selected loyality account has been deleted"));
        }
        else
        {
            response.setResult(ResultBuilder.getResult("selected loyality account doesn't exists"));
        }
        return response;
    }

    private boolean customerExists(final LoyalityAccount loyalityAccount)
    {
        List<Customer> customerList = customerRepository.findAll();
        if (customerList
                .stream()
                .filter(customer -> customer.getFirstname().equals(loyalityAccount.getCustomer().getFirstname()))
                .filter(customer -> customer.getLastname().equals(loyalityAccount.getCustomer().getLastname()))
                .filter(customer -> customer.getBirthday().equals(loyalityAccount.getCustomer().getBirthday()))
                .count() > 0)
            return true;
        else
            return false;
    }

    public void setCustomerRepository(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

}
