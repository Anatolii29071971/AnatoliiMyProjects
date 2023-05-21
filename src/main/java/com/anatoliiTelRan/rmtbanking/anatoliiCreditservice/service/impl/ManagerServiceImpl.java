package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.impl;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Manager;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper.ManagerMapper;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.repository.ManagerRepository;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.ManagerService;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.DataAlreadyExistException;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.DataNotFoundException;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

    @Override
    @Transactional
    public ManagerDto getManagerById(String id) {
        log.info("Get manager by id {}", id);
        return managerMapper.toDto(managerRepository.findManagerById(Long.parseLong(id)).orElseThrow(
                ()-> {
                    log.warn(ErrorMessage.MANAGER_NOT_FOUND);
                    throw new DataNotFoundException(ErrorMessage.MANAGER_NOT_FOUND);
                }));
    }
    @Override
    @Transactional
    public List<ManagerDto> getAllManagersWithClients() {
        log.info("Get all managers with clients");
        List<ManagerDto> resultList = new ArrayList<>(managerMapper.toListDto(managerRepository.getAllByClientsNotNull()));
        if (resultList.size() == 0) {
            log.warn(ErrorMessage.MANAGER_NOT_FOUND);
            throw new DataNotFoundException(ErrorMessage.MANAGER_NOT_FOUND);
        }
        return resultList;
    }

    @Override
    @Transactional
    public ManagerAfterCreateDto managerNewCreate(ManagerCreateDto managerCreateDto) {
        log.info("Create new manager");
        Manager manager = managerMapper.toCreateEntity(managerCreateDto);
        managerRepository.findAll().forEach(m -> {
            if (m.equals(manager)) {
                log.error(ErrorMessage.MANAGER_ALREADY_EXISTS);
                throw new DataAlreadyExistException(ErrorMessage.MANAGER_ALREADY_EXISTS);
            }
        });
        return  managerMapper.toAfterCreateDto(managerRepository.save(manager));
    }
}

