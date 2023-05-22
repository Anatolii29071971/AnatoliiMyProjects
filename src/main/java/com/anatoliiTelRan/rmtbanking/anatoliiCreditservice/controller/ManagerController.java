package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.controller;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.dto.ManagerListDto;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {
    public final ManagerService managerService;

    @GetMapping("/id/{managerId}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDto getManagerById(@PathVariable("managerId") String managerId) {
        return managerService.getManagerById(managerId);
    }
    @GetMapping("/all/withClients")
    @ResponseStatus(HttpStatus.OK)
    public ManagerListDto getAllManagers() {
        return managerService.getAllManagersWithClients();
    }
}
