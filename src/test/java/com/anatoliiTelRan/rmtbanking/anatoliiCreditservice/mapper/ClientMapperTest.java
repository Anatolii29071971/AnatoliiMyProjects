package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientWithBalanceDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.DtoCreator;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Client mapper test class")
class ClientMapperTest {
    private final ClientMapper clientMapper = new ClientMapperImpl();

    @DisplayName("Positive test. Client mapper to DTO")
    @Test
    void toDtoTest() {
        Client client = EntityCreator.getClientEntity();
        ClientDto expectedClientDto = DtoCreator.getClientDto();
        Assertions.assertEquals(expectedClientDto, clientMapper.toDto(client));
    }

    @DisplayName("Positive test. Client mapper to DTO")
    @Test
    void toDtoWithBalanceTest() {
        Client client = EntityCreator.getClientEntity();
        ClientWithBalanceDto expectedClientDto = DtoCreator.getClientWithBalanceDto();
        Assertions.assertEquals(expectedClientDto, clientMapper.toDtoWithBalance(client));
    }

    @DisplayName("Positive test. Create client from DTO")
    @Test
    void toEntityTest() {
        ClientDto clientDto = DtoCreator.getClientDto();
        Client expectedClient = EntityCreator.getClientEntity();
        Assertions.assertEquals(expectedClient, clientMapper.toEntity(clientDto));
    }

    @DisplayName("Positive test. Client mapper to list DTO")
    @Test
    void toListDtoWithBalanceTest() {
        Client client = EntityCreator.getClientEntity();
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        ClientWithBalanceDto expectedClientDto = DtoCreator.getClientWithBalanceDto();
        List<ClientWithBalanceDto> expectedClientWithBalanceDtoList = new ArrayList<>();
        expectedClientWithBalanceDtoList.add(expectedClientDto);

        Assertions.assertEquals(expectedClientWithBalanceDtoList, clientMapper.toListDtoWithBalance(clientList));
    }
}