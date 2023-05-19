package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ClientWithBalanceDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);

    ClientWithBalanceDto toDtoWithBalance(Client client);

    Client toEntity(ClientDto clientDto);

    List<ClientWithBalanceDto> toListDtoWithBalance(List<Client> clients);
}
