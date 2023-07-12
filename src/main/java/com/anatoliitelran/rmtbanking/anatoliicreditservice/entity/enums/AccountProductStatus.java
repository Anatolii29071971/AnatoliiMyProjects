package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum AccountProductStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING");
    private final String value;

    AccountProductStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
