package com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf;

import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ClientWithBalanceListDto;

public interface ClientService {

    ClientWithBalanceListDto getListClientsWithBalanceMoreThan(String balance);
}
