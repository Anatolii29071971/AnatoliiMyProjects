package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum ClientStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING");
    private final String value;
    ClientStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}