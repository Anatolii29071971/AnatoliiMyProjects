package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum ManagerStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING");
    private final String value;

    ManagerStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}