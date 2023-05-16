package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.controller;



import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountsListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all/active")
    @ResponseStatus(HttpStatus.OK)
    public AccountsListDto getAllAccounts() {
        return accountService.getAllAccountsByStatusActive();
    }
}
