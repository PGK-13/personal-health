package org.example.controller;

import org.example.pojo.dto.SleepDTO;
import org.example.pojo.result.Result;
import org.example.pojo.entity.Sleep;
import org.example.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sleep")
public class SleepController {
    @Autowired
    private SleepService sleepService;

    @GetMapping("/list")
    private Result list(SleepDTO sleepDTO) {
        return sleepService.list(sleepDTO);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Sleep sleep) {
        return sleepService.add(sleep);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        return sleepService.delete(id);
    }
}
