package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Manager;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.enums.ManagerStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring",injectionStrategy = CONSTRUCTOR, imports = {LocalDateTime.class, ManagerStatus.class})
public interface ManagerMapper {
    ManagerDto toDto(Manager manager);
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(ManagerStatus.PENDING)")
    Manager toCreateEntity(ManagerCreateDto managerDto);
    List<ManagerDto> toListDto(List<Manager> managers);
    ManagerAfterCreateDto toAfterCreateDto(Manager manager);
}
