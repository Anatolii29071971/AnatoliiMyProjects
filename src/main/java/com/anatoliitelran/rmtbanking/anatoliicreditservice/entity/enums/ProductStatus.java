package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums;

public enum ProductStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING");
    private final String value;

    ProductStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}