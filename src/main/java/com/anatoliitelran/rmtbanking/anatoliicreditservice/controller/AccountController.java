package com.anatoliitelran.rmtbanking.anatoliicreditservice.controller;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.AccountService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.EnumAccountStatusOrNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

}
