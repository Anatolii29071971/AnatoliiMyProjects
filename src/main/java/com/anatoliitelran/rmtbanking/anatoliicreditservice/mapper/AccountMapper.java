package com.anatoliitelran.rmtbanking.anatoliicreditservice.mapper;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountAfterCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", uses = UuidMapper.class,injectionStrategy = CONSTRUCTOR, imports = {LocalDateTime.class})
public interface AccountMapper {
    @Mapping(source = "account.client.firstName", target = "clientFirstName")
    @Mapping(source = "account.client.lastName", target = "clientLastName")
    AccountDto toDto(Account account);

    AccountAfterCreateDto toDtoAfterCreate(Account account);
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    Account toEntity(AccountCreateDto accountCreateDto);

    List<AccountDto> toListDto(List<Account> accounts);
    List<AccountAfterCreateDto> toListAfterCreateDto(List<Account> accounts);
}
