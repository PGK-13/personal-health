package org.example.controller;

import org.example.pojo.result.Result;
import org.example.pojo.entity.VitalSign;
import org.example.service.VitalSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vitalSign")
public class VitalSignController {

    @Autowired
    private VitalSignService vitalSignService;

    @PutMapping("/update")
    public Result update(@RequestBody VitalSign vitalSign) {
        return vitalSignService.update(vitalSign);
    }

    @GetMapping("/list")
    public Result list() {
        return vitalSignService.list();
    }
}
