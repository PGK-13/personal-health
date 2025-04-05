package org.example.controller;

import org.example.pojo.result.Result;
import org.example.service.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseTypeController {

    @Autowired
    private ExerciseTypeService exerciseTypeService;

    @GetMapping("/list")
    public Result list(@RequestParam int currentPage) {
        return exerciseTypeService.list(currentPage);
    }

}
