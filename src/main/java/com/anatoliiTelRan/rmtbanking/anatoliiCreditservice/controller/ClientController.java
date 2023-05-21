package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.controller;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientWithBalanceListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    public final ClientService clientService;

    @GetMapping("/balance_more/{balance}")
    @ResponseStatus(HttpStatus.OK)
    public ClientWithBalanceListDto getListClientsWithBalanceMoreThan(@PathVariable("balance") String balance) {
        return clientService.getListClientsWithBalanceMoreThan(balance);
    }
}
