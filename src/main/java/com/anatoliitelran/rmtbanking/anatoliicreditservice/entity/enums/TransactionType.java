package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum TransactionType {

    PENDING("PENDING");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}