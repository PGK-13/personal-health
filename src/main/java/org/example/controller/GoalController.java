package org.example.controller;

import org.example.pojo.dto.GoalDTO;
import org.example.pojo.result.Result;
import org.example.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/4/1
 */
@RestController
@RequestMapping("/goal")
public class GoalController {
    @Autowired
    public GoalService goalService;

    @GetMapping("/list/{currentPage}")
    public Result list(@PathVariable int currentPage) {
        return goalService.list(currentPage);
    }

    @PostMapping("/add")
    public Result add(@RequestBody GoalDTO goalDTO) {
        return goalService.add(goalDTO);
    }
}
