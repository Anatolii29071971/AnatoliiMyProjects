package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.interf;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerListDto;

import java.util.List;

public interface ManagerService {
    ManagerDto getManagerById(String id);
    List<ManagerDto> getAllManagersWithClients();
    ManagerAfterCreateDto managerNewCreate(ManagerCreateDto managerCreateDto);

}
