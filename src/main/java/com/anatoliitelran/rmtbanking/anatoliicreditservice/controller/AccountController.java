package com.anatoliitelran.rmtbanking.anatoliicreditservice.controller;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

}
