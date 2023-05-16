package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Manager;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerDto toDto(Manager manager);
    Manager toEntity(ManagerDto managerDto);
    List<ManagerDto> toListDto(List<Manager> managers);
}
