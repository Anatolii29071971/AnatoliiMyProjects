package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.impl;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountsListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.enums.AccountStatus;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper.AccountMapper;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.repository.AccountRepository;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.AccountService;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.AccountNotFoundException;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public AccountDto getAccountById(String id) {
        return accountMapper.toDto(accountRepository.findAccountById(UUID.fromString(id)).orElseThrow(
                () -> new AccountNotFoundException((ErrorMessage.ACCOUNT_NOT_FOUND))));
    }

    @Override
    public AccountsListDto getAllAccountsByStatusActive() {
        return new AccountsListDto(accountMapper.ToListDto(accountRepository.getAllByStatus(AccountStatus.ACTIVE)));
    }
}

