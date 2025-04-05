package org.example.controller;

import org.example.pojo.dto.ExerciseAddDTO;
import org.example.pojo.dto.ExerciseDTO;
import org.example.pojo.entity.Exercise;
import org.example.pojo.result.Result;
import org.example.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exerciseRecord")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/add")
    public Result add(@RequestBody ExerciseAddDTO exerciseAddDTO) {
        return exerciseService.add(exerciseAddDTO);
    }

    @GetMapping("/list")
    public Result pageQuery(ExerciseDTO exerciseDTO) {
        return exerciseService.pageQuery(exerciseDTO);
    }
}
