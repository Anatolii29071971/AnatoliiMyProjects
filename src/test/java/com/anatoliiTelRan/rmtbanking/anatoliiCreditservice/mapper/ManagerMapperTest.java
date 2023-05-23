package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.mapper;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerAfterCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerCreateDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Manager;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.DtoCreator;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Test class ManagerMapper")
class ManagerMapperTest {
    private final ManagerMapper managerMapper = new ManagerMapperImpl();

    @DisplayName("Positive test. Manager mapper to DTO")
    @Test
    void toDtoTest() {
        Manager manager = EntityCreator.getManagerEntity();
        ManagerDto expectedManagerDto = DtoCreator.getManagerDto();

        Assertions.assertEquals(expectedManagerDto, managerMapper.toDto(manager));
    }

    @DisplayName("Positive test. Manager mapper to list DTO")
    @Test
    void toListDtoTest() {
        List<Manager> managerList = new ArrayList<>();
        managerList.add(EntityCreator.getManagerEntity());
        List<ManagerDto> expectedManagerDtoList = new ArrayList<>();
        expectedManagerDtoList.add(DtoCreator.getManagerDto());

        Assertions.assertEquals(expectedManagerDtoList, managerMapper.toListDto(managerList));
    }

    @DisplayName("Positive test. To client for create")
    @Test
    void toCreateEntityTest() {
        ManagerCreateDto managerCreateDto = DtoCreator.getManagerCreateDto();
        Manager expectedManager = EntityCreator.getCreateManagerEntity();

        Assertions.assertEquals(expectedManager, managerMapper.toCreateEntity(managerCreateDto));
    }

    @DisplayName("Positive test. Manager mapper to DTO after create")
    @Test
    void toAfterCreateDtoTest() {
        Manager manager = EntityCreator.getCreateManagerEntity();
        ManagerAfterCreateDto expectedManagerAfterCreateDto = DtoCreator.getManagerAfterCreateDto();
        Assertions.assertEquals(expectedManagerAfterCreateDto, managerMapper.toAfterCreateDto(manager));
    }
}