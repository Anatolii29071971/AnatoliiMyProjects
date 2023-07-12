package com.anatoliitelran.rmtbanking.anatoliicreditservice.controller;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.dto.ManagerDto;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {
    public final ManagerService managerService;

}
