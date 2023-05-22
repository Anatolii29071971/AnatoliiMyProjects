package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.interf;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientWithBalanceListDto;

public interface ClientService {

    ClientWithBalanceListDto getListClientsWithBalanceMoreThan(String balance);
}
