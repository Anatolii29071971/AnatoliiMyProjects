package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum AccountType {


    CURRENT("CURRENT");
    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}