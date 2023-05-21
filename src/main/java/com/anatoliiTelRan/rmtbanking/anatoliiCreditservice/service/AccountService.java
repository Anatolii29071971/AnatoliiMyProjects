package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;


import java.util.List;

public interface AccountService {

    AccountDto getAccountById(String id);
    List<AccountDto> getAllAccounts();
    List<AccountDto> getAllAccountsByStatus(String Status);

    AccountAfterCreateDto createNewAccount(AccountCreateDto accountCreateDto, String clientTaxCode);
    List<AccountAfterCreateDto> blockAccountByProductIdAndStatus(String productId, String status);
}
