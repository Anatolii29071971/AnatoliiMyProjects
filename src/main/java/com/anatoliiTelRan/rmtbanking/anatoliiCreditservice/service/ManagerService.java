package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerListDto;

public interface ManagerService {
    ManagerDto getManagerById(String id);
    ManagerListDto getAllManagersWithClients();

}
