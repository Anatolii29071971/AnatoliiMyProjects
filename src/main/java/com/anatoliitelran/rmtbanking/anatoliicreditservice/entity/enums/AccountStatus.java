package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum AccountStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING"),
    BLOCKED("BLOCKED");
    private final String value;

    AccountStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}