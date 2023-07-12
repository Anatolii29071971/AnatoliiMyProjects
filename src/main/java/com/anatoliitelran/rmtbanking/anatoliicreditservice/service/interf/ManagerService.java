package com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerAfterCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ManagerService {
    ManagerDto getManagerById(String id);
    List<ManagerDto> getAllManagersWithClients();


    @Transactional
    ManagerAfterCreateDto managerNewCreate(ManagerCreateDto managerCreateDto);
}
