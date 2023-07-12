package com.anatoliitelran.rmtbanking.anatoliicreditservice.dto;

import lombok.Value;

import java.util.List;

@Value
public class AccountsListDto {
    List<AccountDto> accountDtoList;
}
