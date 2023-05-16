package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto;

import lombok.Value;

import java.util.List;

@Value
public class AccountsListDto {
    List<AccountDto> accountDtoList;
}
