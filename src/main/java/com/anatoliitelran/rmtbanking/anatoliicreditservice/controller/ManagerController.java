package com.anatoliitelran.rmtbanking.anatoliicreditservice.controller;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.ManagerService;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.PositiveInteger;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {
    public final ManagerService managerService;
    public ManagerDto getManagerById(@PositiveInteger
                                     @Parameter(description = "Unique id, format integer")
                                     @PathVariable("managerId") String managerId) {
        return managerService.getManagerById(managerId);
    }

}
