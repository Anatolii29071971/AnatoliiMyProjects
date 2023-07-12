package com.anatoliitelran.rmtbanking.anatoliicreditservice.service.impl;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountAfterCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Account;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Client;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.AccountStatus;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.AccountType;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.mapper.AccountMapper;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.repository.AccountRepository;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.repository.ClientRepository;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.AccountService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.DataAlreadyExistException;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.DataNotFoundException;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
 @Slf4j
//@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public AccountDto getAccountById(String id) {
        log.info("Get account by id {}", id);
        return accountMapper.toDto(accountRepository.findAccountById(UUID.fromString(id)).orElseThrow(
                () -> {
                   log.warn(ErrorMessage.ACCOUNT_NOT_FOUND);
                    throw new DataNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND);
                }));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountDto> getAllAccounts() {
        List<Account> accountList = accountRepository.getAllBy();
        log.info("Get all accounts");
        if (accountList == null) {
            log.warn(ErrorMessage.ACCOUNTS_NOT_FOUND);
            throw new DataNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND);
        }
        return new ArrayList<>(accountMapper.toListDto(accountList));
    }

    @Override
    @Transactional
    public List<AccountDto> getAllAccountsByStatus(String status) {
        List<Account> accountList = accountRepository.getAllByStatus(AccountStatus.valueOf(status));
        log.info("Get all accounts by status {}", status);
        if (accountList == null) {
            log.warn(ErrorMessage.ACCOUNTS_NOT_FOUND_BY_STATUS);
            throw new DataNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND_BY_STATUS);
        }
        return new ArrayList<>(accountMapper.toListDto(accountList));
    }

    @Override
    @Transactional
    public AccountAfterCreateDto createNewAccount(AccountCreateDto accountCreateDto, String clientTaxCode) {
        log.info("Create new account for client with tax code {}", clientTaxCode);
        Client client = clientRepository.findClientByTaxCode(clientTaxCode);
        AccountAfterCreateDto accountAfterCreateDto;
        Account account;

        if (client == null) {
           log.error(ErrorMessage.CLIENT_NOT_FOUND_BY_TAX_CODE);
            throw new DataNotFoundException(ErrorMessage.CLIENT_NOT_FOUND_BY_TAX_CODE);
        } else if (accountRepository.findAccountByName(accountCreateDto.getName()) != null) {
            log.error(ErrorMessage.ACCOUNT_ALREADY_EXISTS);
            throw new DataAlreadyExistException(ErrorMessage.ACCOUNT_ALREADY_EXISTS);
        }

        account = fillAccount(accountCreateDto, client);
        accountAfterCreateDto = accountMapper.toDtoAfterCreate(account);
        accountRepository.save(account);
        return accountAfterCreateDto;
    }

    private Account fillAccount(AccountCreateDto dto, Client client) {
        Account account;
        account = accountMapper.toEntity(dto);
        if (account.getBalance() == null) account.setBalance((double) 0);
        if (account.getStatus() == null) account.setStatus(AccountStatus.PENDING);
        if (account.getType() == null) account.setType(AccountType.CURRENT);
        account.setClient(client);
        return account;
    }

    @Override
    @Transactional
    public List<AccountAfterCreateDto> blockAccountByProductIdAndStatus(String productId, String status) {
        log.info("Change account status to BLOCKED for account with status {} and product id {} ", status, productId);
        List<Account> accountsByStatus = accountRepository.getAllByStatus(AccountStatus.valueOf(status));
        List<Account> accountsByStatusAndProductId = new ArrayList<>();
        Integer prodId = Integer.valueOf(productId);
        accountsByStatus.forEach(account -> {
            if (Objects.equals(account.getAgreement().getProduct().getId(), prodId)) {
                account.setStatus(AccountStatus.BLOCKED);
                account.setUpdatedAt(LocalDateTime.now());
                accountsByStatusAndProductId.add(account);
            }
        });
        if (accountsByStatusAndProductId.size() == 0) {
            log.warn(ErrorMessage.ACCOUNTS_NOT_FOUND_BY_STATUS_AND_PRODUCT_ID);
            throw new DataNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND_BY_STATUS_AND_PRODUCT_ID);
        }
        return new ArrayList<>(accountMapper.toListAfterCreateDto(accountRepository.saveAll(accountsByStatusAndProductId)));
    }
}

