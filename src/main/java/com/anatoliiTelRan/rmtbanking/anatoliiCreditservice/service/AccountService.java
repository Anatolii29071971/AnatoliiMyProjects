package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountsListDto;

public interface AccountService {

    AccountDto getAccountById(String id);

   AccountsListDto getAllAccountsByStatusActive();
}
