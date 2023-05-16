package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;



import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring", uses = UuidMapper.class)
public interface AccountMapper {
    @Mapping(source = "account.client.firstName", target="clientFirstName")
    @Mapping(source = "account.client.lastName", target="clientLastName")
    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);

    List<AccountDto> ToListDto(List<Account> accounts);
}
