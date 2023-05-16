package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.impl;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper.ManagerMapper;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.repository.ManagerRepository;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.ManagerService;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.ErrorMessage;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.ManagerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ManagerServiceImp implements ManagerService {
    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

    @Override
    public ManagerDto getManagerById(String id) {
        return managerMapper.toDto(managerRepository.findManagerById(Long.parseLong(id)).orElseThrow(
                ()-> new ManagerNotFoundException(ErrorMessage.MANAGER_NOT_FOUND)));
    }
    @Override
    public ManagerListDto getAllManagersWithClients() {
        return new ManagerListDto(managerMapper.toListDto(managerRepository.getAllByClientsNotNull()));
    }

}

