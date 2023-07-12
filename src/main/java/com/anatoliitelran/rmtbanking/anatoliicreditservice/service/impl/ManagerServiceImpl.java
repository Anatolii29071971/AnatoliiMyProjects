package com.anatoliitelran.rmtbanking.anatoliicreditservice.service.impl;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerAfterCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerCreateDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Manager;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.mapper.ManagerMapper;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.repository.ManagerRepository;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.ManagerService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.DataAlreadyExistException;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.DataNotFoundException;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.exception.ErrorMessage;
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
                () -> {
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
        return managerMapper.toAfterCreateDto(managerRepository.save(manager));
    }

}

