package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Account;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.DtoCreator;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.EntityCreator;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper.impl.AccountMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Account mapper test class")
class AccountMapperTest {
    private final AccountMapper accountMapper = new AccountMapperImpl();

    @DisplayName("Positive test. Account mapper to DTO test")
    @Test
    void toDtoTest() {
        Account account = EntityCreator.getAccountEntity();
        AccountDto expectedAccountDto = DtoCreator.getAccountDto();
        Assertions.assertEquals(expectedAccountDto, accountMapper.toDto(account));
    }

    @DisplayName("Positive test. Account mapper to DTO after creating")
    @Test
    void toDtoAfterCreateTest() {
        Account account = EntityCreator.getAccountEntity();
        AccountAfterCreateDto expectedAccountDto = DtoCreator.getAccountAfterCreateDto("ACTIVE");
        Assertions.assertEquals(expectedAccountDto, accountMapper.toDtoAfterCreate(account));
    }

    @DisplayName("Positive test. Create from DTO to account")
    @Test
    void toEntityTest() {
        AccountCreateDto accountCreateDto = DtoCreator.getAccountCreateDto();
        Account expectAccount = EntityCreator.getAccountEntity();
        Assertions.assertEquals(expectAccount, accountMapper.toEntity(accountCreateDto));
    }

    @DisplayName("Positive test. Account mapper to list DTO")
    @Test
    void toListDtoTest() {
        Account account = EntityCreator.getAccountEntity();
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        AccountDto expectedAccountDto = DtoCreator.getAccountDto();
        List<AccountDto> expectedAccountDtoList = new ArrayList<>();
        expectedAccountDtoList.add(expectedAccountDto);
        Assertions.assertEquals(expectedAccountDtoList, accountMapper.toListDto(accountList));
    }

    @DisplayName("Positive test. Account mapper to list after create DTO")
    @Test
    void toListAfterCreateDtoTest() {
        Account account = EntityCreator.getAccountEntity();
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        AccountAfterCreateDto accountAfterCreateDto = DtoCreator.getAccountAfterCreateDto("ACTIVE");
        List<AccountAfterCreateDto> expectedAccountAfterCreateDtoList = new ArrayList<>();
        expectedAccountAfterCreateDtoList.add(accountAfterCreateDto);

        Assertions.assertEquals(expectedAccountAfterCreateDtoList, accountMapper.toListAfterCreateDto(accountList));
    }
}