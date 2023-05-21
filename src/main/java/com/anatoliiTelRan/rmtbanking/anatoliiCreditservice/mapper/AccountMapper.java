package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Account;
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
