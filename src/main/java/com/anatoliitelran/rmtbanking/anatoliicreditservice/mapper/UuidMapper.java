package com.anatoliitelran.rmtbanking.anatoliicreditservice.mapper;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UuidMapper {
    String toString(UUID uuid) {
        return uuid.toString();
    }
}
