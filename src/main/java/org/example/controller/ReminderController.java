package org.example.controller;

import org.example.pojo.dto.ReminderDTO;
import org.example.pojo.result.Result;
import org.example.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@RestController
@RequestMapping("/remind")
public class ReminderController {
    @Autowired
    private ReminderService reminderService;

    @GetMapping("/list/{currentPage}")
    public Result list(@PathVariable int currentPage) {
        return reminderService.list(currentPage);
    }

    @PostMapping("/add")
    public Result add(@RequestBody ReminderDTO reminderDTO) {
        return reminderService.add(reminderDTO);
    }
}
