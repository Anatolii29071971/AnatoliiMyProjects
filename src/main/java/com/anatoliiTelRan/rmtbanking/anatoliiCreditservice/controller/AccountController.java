package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.controller;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountsListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.interf.AccountService;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.validation.annotation.EnumAccountStatusOrNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

    @GetMapping("/id/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getAccountById(@PathVariable("accountId") String accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping("/all/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccounts(@EnumAccountStatusOrNull @PathVariable("status") String status) {
        return accountService.getAllAccountsByStatus(status);
    }
}
