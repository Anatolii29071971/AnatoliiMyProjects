package com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountAfterCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountDto;


import java.util.List;

public interface AccountService {

    AccountDto getAccountById(String id);
    List<AccountDto> getAllAccounts();
    List<AccountDto> getAllAccountsByStatus(String status);

    AccountAfterCreateDto createNewAccount(AccountCreateDto accountCreateDto, String clientTaxCode);
    List<AccountAfterCreateDto> blockAccountByProductIdAndStatus(String productId, String status);
}
