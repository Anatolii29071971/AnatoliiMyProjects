package com.anatoliitelran.rmtbanking.anatoliicreditservice.controller;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.AccountDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.AccountService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.Uuid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;
    @GetMapping("/id/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request for find account by ID",
            description = "If id exists - returns all info about account plus firstname and lastname of owner. " +
                    "If id does not exist - returns exception")
    @ApiResponse(responseCode = "200", description = "Successfully returned account by id", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = AccountDto.class)))
    })

    public AccountDto getAccountById(@Uuid
                                     @Parameter(description = "Unique Id format UUID")
                                     @PathVariable("accountId") String accountId) {
        return accountService.getAccountById(accountId);
    }



}
