package org.example.controller;

import org.example.pojo.dto.DietAddDTO;
import org.example.pojo.dto.DietDTO;
import org.example.pojo.dto.ExerciseDTO;
import org.example.pojo.result.Result;
import org.example.service.DietService;
import org.example.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
@RestController
@RequestMapping("/diet")
public class DietController {
    @Autowired
    private DietService dietService;

    @GetMapping("/list")
    public Result pageQuery(DietDTO dietDTO) {
        return dietService.pageQuery(dietDTO);
    }

    @PostMapping("/add")
    public Result add(@RequestBody DietAddDTO dietAddDTO) {
        return dietService.add(dietAddDTO);
    }
}
