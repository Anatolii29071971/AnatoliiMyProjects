package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }
}
