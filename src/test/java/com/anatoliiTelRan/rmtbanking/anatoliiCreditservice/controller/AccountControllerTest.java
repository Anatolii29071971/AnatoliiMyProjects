package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.controller;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.AccountDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.interf.AccountService;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.DataAlreadyExistException;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.DataNotFoundException;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.ErrorMessage;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.DtoCreator;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.EntityCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    AccountService service;
    @Autowired
    MockMvc mockMvc;
    private final String status = "ACTIVE";
    @DisplayName("Positive test. Status 200, JSON response. Controller for find account by ID")
    @Test
    public void getAccountByIdResponseTest() throws Exception {
        String id = EntityCreator.UUID;
        AccountDto expectAccount = DtoCreator.getAccountDto();
        Mockito.when(service.getAccountById(id)).thenReturn(expectAccount);

        mockMvc.perform(get("/accounts/id/"+id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expectAccount.getId()))
                .andExpect(jsonPath("$.name").value(expectAccount.getName()))
                .andExpect(jsonPath("$.type").value(expectAccount.getType()))
                .andExpect(jsonPath("$.status").value(expectAccount.getStatus()))
                .andExpect(jsonPath("$.balance").value(expectAccount.getBalance()))
                .andExpect(jsonPath("$.currencyCode").value(expectAccount.getCurrencyCode()))
                .andExpect(jsonPath("$.clientFirstName").value(expectAccount.getClientFirstName()))
                .andExpect(jsonPath("$.clientLastName").value(expectAccount.getClientLastName()));
    }

    @DisplayName("Negative test.Invalid ID. Controller for find account by ID")
    @Test
    public void getAccountByIdInvalidIdExceptionTest() throws Exception {
        String uuidId = "1111";
        mockMvc.perform(get("/accounts/id/"+uuidId))
                .andExpect(status().is4xxClientError());
    }
    @DisplayName("Negative test. There are no accounts by status. Controller for find all accounts by given status")
    @Test
    void getAllAccountsByStatusNotExistTest() throws Exception {
        Mockito.when(service.getAllAccountsByStatus(status)).thenThrow(new DataNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND_BY_STATUS));
        mockMvc.perform(get("/accounts/all/" + status))
                .andExpect(status().is4xxClientError());
    }


    @DisplayName("Positive test. JSON response. Controller for create account by given client tax")
    @Test
    void createNewAccountTest() throws Exception {
        String taxCode = "123123123123";
        AccountCreateDto accountCreateDto = DtoCreator.getAccountCreateDto();
        AccountAfterCreateDto accountAfterCreateDto = DtoCreator.getAccountAfterCreateDto("PENDING");
        Mockito.when(service.createNewAccount(accountCreateDto, taxCode)).thenReturn(accountAfterCreateDto);
        mockMvc.perform(post("/accounts/new/client_tax/" + taxCode)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountCreateDto))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(accountAfterCreateDto.getName()))
                .andExpect(jsonPath("$.type").value(accountAfterCreateDto.getType()))
                .andExpect(jsonPath("$.status").value(accountAfterCreateDto.getStatus()))
                .andExpect(jsonPath("$.balance").value(accountAfterCreateDto.getBalance()))
                .andExpect(jsonPath("$.currencyCode").value(accountAfterCreateDto.getCurrencyCode()));

        Mockito.verify(service).createNewAccount(accountCreateDto, taxCode);
    }

    @DisplayName("Negative test. Validation not null input data. Controller for create account by given client tax")
    @Test
    void createNewAccountNotEnoughDataTest() throws Exception {
        String taxCode = "123123123123";
        AccountCreateDto accountCreateDto = DtoCreator.getAccountCreateDtoWithoutNecessaryData();
        mockMvc.perform(post("/accounts/new/client_tax/" + taxCode)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountCreateDto))
                )
                .andExpect(status().isInternalServerError());
    }

    @DisplayName("Negative test. Invalid type input data. Controller for create account by given client tax")
    @Test
    void createNewAccountInvalidTypeDataTest() throws Exception {
        String taxCode = "123123123123";
        AccountCreateDto accountCreateDto = DtoCreator.getAccountCreateDtoWithInvalidData();
        mockMvc.perform(post("/accounts/new/client_tax/" + taxCode)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountCreateDto))
                )
                .andExpect(status().isInternalServerError());
    }

    @DisplayName("Negative test. Account already exist. Controller for create account by given client tax")
    @Test
    void createNewAccountAlreadyExistAccountTest() throws Exception {
        String taxCode = "123123123123";
        AccountCreateDto accountCreateDto = DtoCreator.getAccountCreateDto();
        Mockito.when(service.createNewAccount(accountCreateDto, taxCode)).thenThrow(new DataAlreadyExistException(ErrorMessage.ACCOUNT_ALREADY_EXISTS));
        mockMvc.perform(post("/accounts/new/client_tax/" + taxCode)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountCreateDto))
                )
                .andExpect(status().is4xxClientError());
    }


    @DisplayName("Positive test. Server status 200. Controller for update account by given account status and product id")
    @Test
    void blockAccountByProductIdAndStatusTest() throws Exception {
        String productId = "1";
        AccountAfterCreateDto accountAfterCreateDto = DtoCreator.getAccountAfterCreateDto("BLOCKED");
        List<AccountAfterCreateDto> resultListDto = new ArrayList<>();
        resultListDto.add(accountAfterCreateDto);
        Mockito.when(service.blockAccountByProductIdAndStatus(productId, status)).thenReturn(resultListDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/accounts/block_account/" + productId + "/" + status)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(resultListDto)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("BLOCKED"));
    }

    @DisplayName("Negative test. Invalid product Id. Controller for update account by given account status and product id")
    @Test
    void blockAccountByProductIdAndStatusWithInvalidProductIdTest() throws Exception {
        String productId = "-123.4";
        mockMvc.perform(MockMvcRequestBuilders.put("/accounts/block_account/" + productId + "/" + status))
                .andExpect(status().isInternalServerError());
    }

    @DisplayName("Negative test. Invalid product Id. Controller for update account by given account status and product id")
    @Test
    void blockAccountByProductIdAndStatusDataNotFoundTest() throws Exception {
        String productId = "1";
        Mockito.when(service.blockAccountByProductIdAndStatus(productId, status)).thenThrow(new DataNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND_BY_STATUS_AND_PRODUCT_ID));

        mockMvc.perform(MockMvcRequestBuilders.put("/accounts/block_account/" + productId + "/" + status)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is4xxClientError());
    }
}