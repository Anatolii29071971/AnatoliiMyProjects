package com.anatoliitelran.rmtbanking.anatoliicreditservice.mapper;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ClientDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ClientWithBalanceDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);

    ClientWithBalanceDto toDtoWithBalance(Client client);

    Client toEntity(ClientDto clientDto);

    List<ClientWithBalanceDto> toListDtoWithBalance(List<Client> clients);
}
