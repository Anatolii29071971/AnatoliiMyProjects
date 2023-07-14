package com.anatoliitelran.rmtbanking.anatoliicreditservice.controller;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.AccountService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.Uuid;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

    public AccountDto getAccountById(@Uuid
                                     @Parameter(description = "Unique Id format UUID")
                                     @PathVariable("accountId") String accountId) {
        return accountService.getAccountById(accountId);
    }



}
