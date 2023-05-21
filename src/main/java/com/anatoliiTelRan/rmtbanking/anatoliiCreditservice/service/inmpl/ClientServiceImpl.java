package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.inmpl;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientWithBalanceListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper.ClientMapper;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.repository.ClientRepository;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.ClientService;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.DataNotFoundException;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.ErrorMessage;
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
