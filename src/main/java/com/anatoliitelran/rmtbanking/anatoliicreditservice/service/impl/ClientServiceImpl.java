package com.anatoliitelran.rmtbanking.anatoliicreditservice.service.impl;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ClientWithBalanceListDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Client;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.mapper.ClientMapper;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.repository.ClientRepository;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.ClientService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.DataNotFoundException;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    final private ClientRepository clientRepository;

    final private ClientMapper clientMapper;


    @Override
    public ClientWithBalanceListDto getListClientsWithBalanceMoreThan(String balance) {
        log.info("Get list of client with balance more than {}", balance);
        double balanceD;
        balanceD = Double.parseDouble(balance);
        List<Client> clientList = clientRepository.findClientsBy(balanceD);
        if (clientList.size() == 0) {
            log.warn(ErrorMessage.CLIENTS_NOT_FOUND);
            throw new DataNotFoundException(ErrorMessage.CLIENTS_NOT_FOUND);
        }
        return new ClientWithBalanceListDto(clientMapper.toListDtoWithBalance(clientList));

    }
}
